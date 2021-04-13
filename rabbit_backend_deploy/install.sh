#!/bin/sh

# Exit on errors
set -e

# Install docker, iff it is not installed yet.
if ! command -v docker > /dev/null 2>&1; then
  apt update
  apt install docker.io
fi

mkdir -p "${LETSENCRYPT_ACME:-/var/lib/letsencrypt}"
mkdir -p "${LETSENCRYPT_ROOT:-/etc/letsencrypt}"/ssl
openssl dhparam -out /etc/letsencrypt/ssl/dhparams.pem 2048

# Bootstrap certificates with --standalone server.
docker-compose run --service-ports --rm \
  certbot-bootstrap \
    --cert-name rabbit.info \
    -d rabbit.info -d www.rabbit.info --verbose

echo ""
echo "****************************************"
echo "*     Wait for services to go up,      *"
echo "*     Then press     Ctrl-c            *"
echo "*     to detach from docker-compose.   *"
echo "****************************************"
echo ""
sleep 5  # make sure user notices warning.

# Start server
docker-compose up -d nginx server
# Check logs interactively
trap "true" INT  # don nothing upon Ctrl-c
docker-compose logs -f || true  # do not fail because docker-compose exits with status 1
trap - INT       # restore handler

# Run certbot again, to switch config to webroot,
# so that we can run renew without arguments.
docker-compose run --rm \
  certbot certonly \
    --webroot \
    --webroot-path /var/lib/letsencrypt \
    --cert-name rabbit.info \
    -d rabbit.info -d www.rabbit.info

# Test renew setup
docker-compose run --rm \
  certbot renew
