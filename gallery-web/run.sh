#!/bin/bash

cd "$(dirname "$0")"

docker-compose up -d --build --force-recreate