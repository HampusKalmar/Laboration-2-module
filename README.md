# Project Generator API

## Prerequisites
	- Installed JDK (Java Development Kit)
	- Installed JVM (Java Virual Machine)
	- Installed Gradle

## Important information
Right now, the API is only owkring with Kotlin DSL. So when you use my API, be sure to check that you want to use the Kotlin DSL and not Groovy.

## Add ProjectGeneratorAPI to your Java project

### If you are using Kotlin DSL:
    repositories {
        mavenCentral()  
        maven("https://jitpack.io")
    }

    dependencies { 
        implementation("com.github.HampusKalmar:Laboration-2-module:v1.0.2")
    }

## API Usage

### Import in your project
import com.projectgenerator.api.ProjectGeneratorAPI;

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
