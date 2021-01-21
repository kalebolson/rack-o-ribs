#!/bin/bash

yum update
yum install git java gradle -y
git clone https://github.com/kalebolson/rack-o-ribs.git
java -jar ~/rack-o-ribs/build/libs/*
