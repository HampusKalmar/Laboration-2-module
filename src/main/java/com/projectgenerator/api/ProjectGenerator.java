package com.projectgenerator.api;

interface ProjectGenerator {
    void createDirectory(String directoryPath, String directoryName);
    void setProperties(String directoryPath, String fileName, String content);
    void createFile();
    void findSearchedFile(String directoryPath, String fileName);
    void printDirectoryContent(String directoryPath);
    void deleteFile(String directoryPath, String fileName);
}
