#!/bin/bash

DIR="myFiles"

#check if directory exists then delete
if [ -d "$DIR" ]; then
    rm -rf "$DIR"
fi

#create directory
mkdir "$DIR"

if [ -d "$DIR" ]; then
    echo "$DIR directory was created"
fi

cd "$DIR"

#create 7 files and verify that they were created
touch file{1..7}.txt

for file in file{1..7}.txt
   do
     if [ ! -f "$file" ]; then
         echo "$file file was not created"
     else
         echo "$file file was created"
     fi
   done


#Sort(t indicates sort contents by modification time, newest first) and not remove last 3 created files
ls -1t | tail -n +4 | xargs rm -f

for file in file{1..7}.txt
   do
     if [ ! -f "$file" ]; then
         echo "$file file was deleted"
     else
         echo "$file file still exists"
     fi
   done