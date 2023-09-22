# Project Generator API

## Prerequisites
	- Installed JDK (Java Development Kit)
	- Installed JVM (Java Virual Machine)
	- Installed Gradle

## Add ProjectGeneratorAPI to your Java project

### If you are using Kotlin DSL:
    repositories {
        mavenCentral()  
        maven("https://jitpack.io")
    }

    dependencies { 
        implementation("com.github.HampusKalmar:Laboration-2-module:v1.0.2")
    }

### If you are using Maven: 
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>


    <dependency>
	    <groupId>com.github.HampusKalmar</groupId>
	    <artifactId>Laboration-2-module</artifactId>
	    <version>v1.0.2</version>
	</dependency>

### If you are using gradle: 
    allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}

    dependencies {
	    implementation 'com.github.HampusKalmar:Laboration-2-module:v1.0.2'
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
