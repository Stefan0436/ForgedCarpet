#!/bin/sh
commit=$(git log --committer=DeadlyMC --format=%H -n 1)
usecommit=Latest

if [ ! -d Patches ] ; then mkdir Patches; fi

if [ "$1" != "" ] && [ "$1" != "Latest" ]; then commit=$1; fi
if [ "$2" != "" ]; then usecommit=$2; fi

short=$(git rev-parse --short $commit)
short2=$usecommit

if [ "$usecommit" != "Latest" ]; then short2=$(git rev-parse --short $usecommit); fi

committitle=$(git show $commit --format=%B -n 1 | head -n 1)
if [ "$usecommit" != "Latest" ]; then usecommittitle=$(git show $usecommit --format=%B -n 1 | head -n 1) ; else usecommittitle="Unknown" ; fi

filename="Source Patch - &date1 (${short}, &ctitle) - &date2 (${short2}, &c2title).patch"
if [ "$usecommit" == "Latest" ]; then filename="Source Patch - &date1 (${short}, &ctitle) - &date2 (${short2}).patch" ; fi
if [ "$3" != "" ]; then filename="$3"; fi

date2=$(date +"%2d-%2m-%4Y %H-%M" -u)
if [ "$usecommit" != "Latest" ]; then date2=$(date --date="$(TZ=UTC git show -s --format=%cd --date=local $usecommit)" --utc +"%2d-%2m-%4Y %H-%M"); fi

filename=$(echo $filename | sed "s/&short2/${short2}/"  | sed "s/&short/${short}/" | sed "s/&actualcommit/${commit}/" | sed "s/&shortcommit/${short}/" | sed "s/&date1/$(date --date="$(TZ=UTC git show -s --format=%cd --date=local $commit)" --utc +"%2d-%2m-%4Y %H-%M")/" | sed "s/&date2/$date2/" | sed "s/&ctitle/$committitle/" | sed "s/&c2title/$usecommittitle/")

echo Generating patch using commit $commit and ${usecommit}...

if [ "$usecommit" == "Latest" ]; then usecommit=""; fi

rm -f "Patches/${filename}" ; git diff --binary $commit $usecommit >> "Patches/${filename}"
if [ $? -eq 0 ]; then echo Patch created, name: \'${filename}\', saved in Patches directory. ; fi
echo
