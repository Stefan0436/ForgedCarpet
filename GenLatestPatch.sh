#!/bin/sh
if [ ! -d Patches ] ; then mkdir Patches; fi

commit=$(git log --format=%H -n 1)
uselastcommit=$(git log --format=%H -n 2 | tail -n 1)

find Patches/ -name 'Latest Official Patch - *.patch' -delete
find Patches/ -name 'Latest Update Patch - *.patch' -delete

sh GenPatch.sh Latest Latest "Latest Official Patch - &date1 (&short, &ctitle) - &date2 (&short2).patch"
sh GenPatch.sh $commit Latest "Latest Update Patch - &date1 (&short, &ctitle) - &date2 (&short2).patch"
sh GenPatch.sh $uselastcommit $commit
sh GenPatch.sh Latest $commit
