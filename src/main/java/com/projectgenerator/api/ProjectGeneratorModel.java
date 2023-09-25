package com.projectgenerator.api;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.io.File;
import java.io.FileFilter;

class ProjectGeneratorModel {

    /**
     * Creates a file with the content inside the file. 
     *
     * @param directoryPath Directory where the file is to be created.
     * @param fileName The name of the file.
     * @param content The content of the file.
     */
    public void checkFileWithContent(String directoryPath, String fileName, String content) {
        Path fullPath = Paths.get(directoryPath, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath.toString()))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file: " + fileName, e);
        }
    }

    /**
     * Checks if the specified path exists and is a directory.
     *
     * @param path The path where to check for directory.
     */
    public void checkPath(String path) {
        if (path == null) {
            throw new RuntimeException("The specified directory path cannot be null: " + path);
        }

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("The specified directory path is not valid: " + path);
        }
    }

    /**
     * Creates a directory for the user with a name if it does not already exist.
     *
     * @param fullDirectoryPath The path the user has choosen to create directory.
     */
    public void checkDirectory(String fullDirectoryPath) {
        File directory = new File(fullDirectoryPath);
        if (directory.exists()) {
           throw new RuntimeException("Directory already exists: " + fullDirectoryPath);
        }
        if (!directory.mkdir()) {
            throw new RuntimeException("Failed to create new directory: " + fullDirectoryPath);
        }
    }

    /**
     * Searches for files with a specific name in a given directory.
     *
     * @param directoryPath The absolute path of the directory where the search is to be performed.
     * @param fileName The name of the file.
     * @return An ArrayList of String containing the names of all matching files.
     */
    public ArrayList<String> searchFile(String directoryPath, String fileName) {
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("The directory does not exist or is not a directory: " + directoryPath);
        }

        File[] matchingFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().equals(fileName);
            } 
        });

        if (matchingFiles == null || matchingFiles.length == 0) {
            throw new RuntimeException("No matching files found in directory: " + directoryPath);
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
     * @return The content of all the files and directories in the path the user has choosen.
     */
    public ArrayList<String> listDirectoryContent(String directoryPath) {
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
     */
    public boolean findFile(String directoryPath, String fileName) {
        Path filePath = Paths.get(directoryPath, fileName);
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fetches the file size in bytes and then returns the size in a string. 
     *
     * @param filePath The path the user has choosen to check the file size.
     * @return The size of the file in bytes.
     */
    public long fecthFileSize(String filePath) {
        Path path = Paths.get(filePath);
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            return attributes.size();
        } catch (IOException e) {
            throw new RuntimeException("Error fetching file metadata");
        }
    }
}