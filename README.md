# Project Generator API

## API Usage
### Create a directory
ProjectGenerator projectGenerator = new ProjectGenerator();
projectGenerator.createDirectory("path/to/directory", "myNewDirectory");

### Create a file with content 
ProjectGenerator projectGenerator = new ProjectGenerator();
projectGenerator.createFileWithContent("path/to/directory", "myNewFile.txt", "Hello World!");

### Search for a file
ProjectGenerator projectGenerator = new ProjectGenerator();
ArrayList<String> foundFile = projectGenerator.findSearchedFile("path/to/directory");

### Print directory content
ProjectGenerator projectGenerator = new ProjectGenerator();
project.printDirectoryContent("path/to/directory");
