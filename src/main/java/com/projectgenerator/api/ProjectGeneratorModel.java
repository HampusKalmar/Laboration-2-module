package com.projectgenerator.api;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.FileFilter;

class ProjectGeneratorModel {

    /**
     * Creates a file with the content inside the file. 
     *
     * @param fileName The name of the file.
     * @param content The content of the file.
     */
    public void checkFileWithContent(String directoryPath, String fileName, String content) throws IOException {
        Path fullPath = Paths.get(directoryPath, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath.toString()))) {
            writer.write(content);
        } catch (IOException e) {
            throw new IOException("Failed to create file: " + fileName, e);
        }
    }

    /**
     * Checks the path of the created directory. 
     *
     * @param path The path where the directory is located.
     * @throws IOException Throws a I/O exception if a path does not exist or is not a directory.
     */
    public void checkPath(String path) throws IOException {
        if (path == null) {
            throw new IOException("The specified directory path cannot be null: " + path);
        }

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("The specified directory path is not valid: " + path);
        }
    }

    /**
     * Creates a directory for the user with a name. 
     *
     * @param userDirectory The directory the user created.
     * @throws IOException Throws a I/O exception if a directory could not be created.
     */
    public void checkDirectory(String fullDirectoryPath) throws IOException {
        File directory = new File(fullDirectoryPath);
        if (directory.exists()) {
           throw new IOException("Directory already exists: " + fullDirectoryPath);
        }
        if (!directory.mkdir()) {
            throw new IOException("Failed to create new directory: " + fullDirectoryPath);
        }
    }

    /**
     * Searches for files with a specific name in a given directory.
     *
     * @param directoryPath The absolute path of the directory where the search is to be performed.
     * @param fileName The name of the file.
     * @return An ArrayList of String containing the names of all matching files.
     * @throws IOException Throws a I/O exception if a path does not exist or is not a directory.
     */
    public ArrayList<String> searchFile(String directoryPath, String fileName) throws IOException {
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("The directory does not exist or is not a directory: " + directoryPath);
        }

        File[] matchingFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().equals(fileName);
            } 
        });

        if (matchingFiles == null || matchingFiles.length == 0) {
            throw new IOException("No matching files found in directory: " + directoryPath);
        }

        ArrayList<String> result = new ArrayList<>();
        for (File file : matchingFiles) {
            result.add(file.getName());
        }
        return result;
    }

    /**
     * Lists the files and folders in the directory the user have choosen. 
     *
     * @param directoryPath The path where the user wants to list all the content.
     * @return The content of all the files and modules in that directory.
     */
    public ArrayList<String> listDirectoryContent(String directoryPath) throws IOException {
        ArrayList<String> directoryContent = new ArrayList<>();
        Path dirPath = Paths.get(directoryPath);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dirPath)) {
            for (Path path : directoryStream) {
                directoryContent.add(path.getFileName().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directoryContent;
    }

    /**
     * Finds a file in the given directory with the given name. 
     *
     * @param directoryPath The path where the file exist.
     * @param fileName The name of the file.
     * @return Boolean if the file exists or not.
     * @throws IOException If an I/O error occurs.
     */
    public boolean findFile(String directoryPath, String fileName) throws IOException {
        Path filePath = Paths.get(directoryPath, fileName);
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return true;
        } else {
            return false;
        }
    }
}