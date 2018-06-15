#!/bin/bash
if [ "$(docker ps -aq -f name=ibreath-cont)" ]; then
  # cleanup
  docker rm --force ibreath-cont
fi
exit 0