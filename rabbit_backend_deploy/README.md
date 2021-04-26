#Setup

## Environment

Environment variables for docker are configurable via `.env` file.

- `LETSENCRYPT_ROOT`: defaults to `/etc/letsencrypt`.
- `LETSENCRYPT_ACME`: defaults to `/var/lib/letsencrypt`.
- `LETSENCRYPT_EMAIL`: default to `admin@rabbit.info`

## Config

Domain name: `rabbit.info` is hardcoded.

- Replace stub services in `docker-compose.yml` with real ones.
- Change services ports in `nginx/sites-enabled/*.upstream.conf` files.
- Edit systemd service -> post-hook option.

## Ubuntu 20.04

Initial install:
- Run `install.sh`
- Wait for all services to initialize. Rate of logging should slow down.
- Press `Ctrl-c` to stop logging.
- Wait while certbot is updating config and verifing its renew command.

# Run

1. Install files in~~~~ `./etc/systemd/system/`
2. Run `systemctl enable --now certbot-renewal.timer`.
3. Verify:
  - `systemctl status certbot-renewal.timer`
  - `journalctl -u certbot-renewal.service`
