# JavaMiniGames

## About project

This project involves the creation of several mini-games in the Java programming 
language using the Swing library. In this pet-project I create 2 mini-games: Snake and Tic Tac Toe. 
I am planing to add some other games like Sudoku, Sea Battle and other. My next step is write Unit-tests 

## What I use

I use Java with builder Gradle. For GUI, I use Swing library, 
maybe for improve the GUI I will use JavaFX library in future updates. 

## How to build

1. Clone the Project

If the project is stored in a version control system like Git,
you first need to clone the repository to the new computer:

```
git clone <repository_URL>
```

2. Install Gradle or Use the Gradle Wrapper

Check if the project uses the Gradle Wrapper (gradlew). 
This script allows you to run Gradle without installing it separately.

If the project has gradlew or gradlew.bat files, you can use them to run 
Gradle commands.

If the Wrapper is not used, you’ll need to install Gradle on the 
computer by following instructions from the official Gradle website.

3. Download Dependencies

After cloning (or copying) the project, you need to 
download all the required dependencies by running:

```
./gradlew build      # For Unix-based systems
./gradlew.bat build  # For Windows
```

Or, if you have Gradle installed globally:
```
gradle build
```

This command will download all necessary dependencies and compile 
the project.

4. Run the Project

After a successful build, you can run the project:

```
./gradlew run
```

Or, if Gradle is installed globally:

```
gradle run
```

