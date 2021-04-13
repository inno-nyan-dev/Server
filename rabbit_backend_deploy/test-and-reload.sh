#!/bin/sh
set -e

docker-compose exec -T nginx nginx -t
docker-compose exec -T nginx nginx -s reload
