# Project Generator API

## Prerequisites to use API
	- Installed JDK (Java Development Kit)
	- Installed JVM (Java Virual Machine)
	- Installed Gradle

## Important information
Right now, the API is only working with Kotlin DSL. So when you use my API, be sure to check that you want to use the Kotlin DSL and not Groovy.

## Add ProjectGeneratorAPI to Java project

### Add this in build.gradle.kts (Kotlin DSL):
    repositories {
        mavenCentral()  
        maven("https://jitpack.io")
    }

    dependencies { 
        implementation("com.github.HampusKalmar:Laboration-2-module:v1.1.4")
    }

## API Usage

### Import in your project
![How to import](static/importAPI.png)

### Create a directory
ProjectGeneratorAPI project = new ProjectGeneratorAPI();
project.createDirectory("path/to/directory", "myNewDirectory");

### Create a file with content 
ProjectGeneratorAPI projec = new ProjectGeneratorAPI();
project.createFileWithContent("path/to/directory", "myNewFile.txt", "Hello World!");

### Search for a file
ProjectGeneratorAPI project = new ProjectGeneratorAPI();
project.findSearchedFile("path/to/directory", "myFile.txt");

### Print directory content
ProjectGeneratorAPI project = new ProjectGeneratorAPI();
project.printDirectoryContent("path/to/directory");

### Delete a file 
ProjectGeneratorAPI project = new ProjectGeneratorAPI();
project.deleteFile("path/to/directory", "myFile.txt")

### Print out file size
ProjectGeneratorAPI project = new ProjectGeneratorAPI();
project.showFileMetaData("path/to/file");