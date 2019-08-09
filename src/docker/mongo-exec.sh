#/bin/bash

docker exec -it $(docker ps -f="name=guppy-mongo" -aq) /bin/bash
