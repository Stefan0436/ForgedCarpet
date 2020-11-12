# ForgedCarpet
Powerful toolbox with ultimate control for technical mc.
<br/><br/>

## Forked by stefan0436, original developer: DeadlyMC
- Updated to Forge 1.12.2-14.23.5.2854
- Updated to Mixin 0.8.1
- Updated ForgeGradle to version 3.0
- Updated MixinGradle to version 0.7
- Added Compiling Guide to readme
- Added Development Environment Setup Guide to readme.
- I try to start comments with 'Stefan0436: ' to show who did what. (in some cases, i forgot to do so)
<br/>

- **Note: I have made no further changes to the readme, if you need help with anything related to this fork, please contact me through issues.**
- **Second note: I am not part of the SciCraft server or their discord server, you cannot contact me from there.**
- **Third note: I do not claim any of the code here, i only am trying to update it to minecraft forge 1.12.2-14.23.5.2854, make a few tweaks to minecraft and fix some compatibility issues with other mods.**

## Compiling guide (not yet working, code needs to be ported):
1. Clone the git repo.
2. Change directory to the cloned repo.
3. Run the following command depending on your os:
- Windows: `./gradlew.bat genEclipseRuns build eclipse`
- Linux: `./gradlew genEclipseRuns build eclipse` (remember to mark gradlew as executable: chmod ug=rwx gradlew)
4. the jar will be saved in the build/libs folder.

## Development Environment Setup Guide (This is for Eclipse, i recommend you to use version 2019-09, because i could not get the project loaded on the version 2020‑09)
- Skip to step 4 if you already compiled the jar before.
1. Clone the repo.
2. Change directory to the cloned repo.
3. Run the following command depending on your os:
- Windows: `./gradlew.bat genEclipseRuns eclipse`
- Linux: `./gradlew genEclipseRuns eclipse` (remember to mark gradlew as executable: chmod ug=rwx gradlew)
4. Create a new workspace (in a different folder than the mod folder)
5. If you have the welcome page open, click 'Workbench' in the top right corner.
6. Press the keys: ALT+F
7. Click Import
8. Open the category 'Gradle' and select 'Existing Gradle Project'
9. Click next until you get to the import page.
10. Click browse (next to the 'Project root directory' box)
11. Select the mod development kit folder
12. Click Finish
<br/>

## General Info
- Mod loader: Forge
- Mod Version: 1.12.2
- Every setting can be toggled on/off using `/carpet` command. Like u would do in carpetmod
  
## Using the mod
Just drop the `.jar` file from the releases section of this mod repository in the mods folder of your game and run mc with 
forge 1.12.2 as you would do with any other mod.

## Feedback
If you have questions or need help with something, the best/fastest way to get answers is currently the #carpet-mod 
channel on the SciCraft Discord server.
