#/bin/bash

docker rm $(docker ps --filter="name=guppy-mongo" -aq)
docker run --name guppy-mongo -p 27017:27017 -d mongo
