package com.projectgenerator.definition;

import java.io.IOException;

public interface ProjectGenerator {
    void createDirectory(String directoryPath, String directoryName) throws IOException;
    void createFileWithContent(String directoryPath, String fileName, String content) throws IOException;
    void findSearchedFile(String directoryPath, String fileName) throws IOException;
    void printDirectoryContent(String directoryPath) throws IOException;
    void deleteFile(String directoryPath, String fileName) throws IOException;
}
