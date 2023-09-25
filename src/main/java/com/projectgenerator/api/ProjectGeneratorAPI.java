package com.projectgenerator.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * ProjectGenerator is responsible for managing various file and directory operations.
 */
public class ProjectGeneratorAPI implements ProjectGenerator {
    private final ProjectGeneratorModel projectModel = new ProjectGeneratorModel();
    private String directoryPath;
    private String fileName;
    private String content;

    /**
     * Default constructor for ProjectGenerator class.
     */
    public ProjectGeneratorAPI() {}

    /**
     * Creates a new directory at the specified path.
     *
     * @param directoryPath The path the user has choosen where the directory will be created.
     * @param directoryName The name of the new directory the user has choosen.
     */
    public void createDirectory(String directoryPath, String directoryName) {
        try {
            String fullDirectoryPath = Paths.get(directoryPath, directoryName).toString();
            projectModel.checkPath(directoryPath);
            projectModel.checkDirectory(fullDirectoryPath);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new file with content at the specified directory path.
     *
     * @param directoryPath The directory path where the file will be created.
     * @param fileName The name of the file the user has choosen to be created.
     * @param content The content to be written to the file.
     */
    public void createFileWithContent(String directoryPath, String fileName, String content) {
        try {
            this.directoryPath = directoryPath;
            this.fileName = fileName;
            this.content = content;
            projectModel.checkFileWithContent(this.directoryPath, this.fileName, this.content);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    // TODO: it sounds like i have already found the file im looking for. maby findfile()?
    /**
     *  Searches for a file by name in the specified directory and then prints the file if it exist.
     *
     * @param directoryPath The directory where to search for the file.
     * @param fileName The name of the file to search for.
     */
    public void findSearchedFile(String directoryPath, String fileName) { 
        try {
            ArrayList<String> foundFiles = projectModel.searchFile(directoryPath, fileName);
            for (String file : foundFiles) {
                System.out.println("Found file: " + file);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Prints the content of a specified directory to the console.
     *
     * @param directoryPath The file path of the directory whose contents are to be printed.
     */
    public void printDirectoryContent(String directoryPath) {
        try {
            ArrayList<String> directoryContent = projectModel.listDirectoryContent(directoryPath);
            for (String content : directoryContent) {
                System.out.println(content);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the file the user has specified.
     *
     * @param directoryPath The directory path to the file that will be deleted.
     * @param fileName The name of the file the user has choosen that will be deleted.
     */
    public void deleteFile(String directoryPath, String fileName) {
        try {
            boolean fileExist = projectModel.findFile(directoryPath, fileName);
            if (fileExist) {
                Files.delete(Paths.get(directoryPath, fileName));
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: printFileSize() is even more clear
    /**
     * Displays the size (in bytes) of the specified file.
     *
     * @param filePath The path the user has choosen to display the file size.
     */
    public void showFileSize(String filePath) {
        try {
            long fileSize = projectModel.fecthFileSize(filePath);
            System.out.println("File size is: " + fileSize + " bytes");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}