#!/bin/bash

if [[ "$2" =~ "compile" ]]
then
    javac --module-path ~/Documents/javafx-sdk-11.0.2/lib \
          --add-modules=javafx.base \
          --add-modules=javafx.controls \
          --add-modules=javafx.media \
          --add-modules=javafx.graphics \
          $1.java
else
    java --module-path ~/Documents/javafx-sdk-11.0.2/lib \
          --add-modules=javafx.base \
          --add-modules=javafx.controls \
          --add-modules=javafx.media \
          --add-modules=javafx.graphics \
          $1
fi