#!/bin/sh -e

docker image build -t zhukovsd/alfabattle:task2 .
docker container run -p 8081:8081 zhukovsd/alfabattle:task2