## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.
## Installation
1. Install JAVA SDK 21
    - navigate to oracle java package installation page, find sdk21 **ARM64 DMG Installer** for macos system - [JAVA_SDK](https://www.oracle.com/java/technologies/downloads/#jdk21-mac)

2. Verfity JAVA Installation
    - in your terminal
    ```
    java --version
    ```

3. Setup JAVA Home
    ```
    touch ~/.zshenv
    open ~/.zshenv
    export JAVA_HOME=$(/usr/libexec/java_home)

    source ~/.zshenv
    echo $JAVA_HOME
    ```


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
