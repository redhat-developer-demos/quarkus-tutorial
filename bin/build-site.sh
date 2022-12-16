#!/bin/sh
docker run -v $PWD:/antora:Z --rm -t antora/antora:2.3.1 --cache-dir=./.cache/antora github-pages.yml
