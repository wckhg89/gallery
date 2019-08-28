#/bin/bash

docker logs -f $(docker ps -f="name=guppy-mongo" -aq)
