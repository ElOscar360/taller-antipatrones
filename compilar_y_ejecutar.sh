#!/bin/bash
# Requiere JDK 17+
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name '*.java') && \
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -cp out consulado.app.Main
