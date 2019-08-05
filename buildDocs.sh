#!/bin/bash 

[[ -d gh-pages ]] && rm -rf gh-pages

docker run -it --rm -v `pwd`:/antora  antora/antora:2.0.0 site.yml --stacktrace
