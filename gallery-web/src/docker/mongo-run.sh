#/bin/bash

docker stop $(docker ps --filter="name=guppy-mongo" -aq)
docker rm $(docker ps --filter="name=guppy-mongo" -aq)
docker run --name guppy-mongo \
-p 27017:27017 \
-v /Users/ganghong-gu/Documents/study/mongo/data/db:/data/db \
-d mongo
