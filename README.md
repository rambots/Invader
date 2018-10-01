# Invader
Robot for FIRST POWER UP 2018

## Setup Instructions

### General
- Clone this repo
- Run `./gradlew` to download gradle and needed FRC libraries
- Run `./gradlew tasks` to see available build options
- Enjoy!

#### Eclipse
- Run `./gradlew eclipse`
- Open Eclipse and go to "File > Open Projects" from "File System..."
- Set the import source to the `FRC-2018` folder then click finish

#### IntelliJ
- Run `./gradlew idea`
- Open the `FRC-2018.ipr` file with IntelliJ

### Building/Deploying to the Robot
- Run `./gradlew build` to build the code. Use the `--info` flag for more details
- Run `./gradlew deploy` to deploy to the robot in Terminal (Mac) or Powershell (Windows)

### Set Build Configuration in IntelliJ
- Open up gradle
- under task folder select build and under embeddedtools select deploy and right click to assign shortcut
- make sure to save as single instance only
