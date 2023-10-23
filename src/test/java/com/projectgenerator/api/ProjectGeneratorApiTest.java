package com.projectgenerator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class ProjectGeneratorApiTest {
    private ProjectGeneratorAPI projectGenerator;

    @BeforeEach
    public void setup() {
        projectGenerator = new ProjectGeneratorAPI();
    }

    @Test
    public void testCreateDirectory(@TempDir Path tempDir) throws IOException {
        projectGenerator.createDirectory(tempDir.toString(), "newDir");

        Path newDir = tempDir.resolve("newDir");
        assertTrue(Files.exists(newDir));
        assertTrue(Files.isDirectory(newDir));
    }

    @Test
    public void testCreateFile(@TempDir Path tempDir) throws IOException {
        String directoryName = "testDir";
        String fileName = "hello.txt";

        projectGenerator.createDirectory(tempDir.toString(), directoryName);
        Path directoryPath = tempDir.resolve(directoryName);

        projectGenerator.setProperties(directoryPath.toString(), fileName, "Hello, World!");
        projectGenerator.createFile();
       
        Path newFile = directoryPath.resolve(fileName);
        assertTrue(Files.exists(newFile));
        assertTrue(Files.isRegularFile(newFile));
    }

    @Test
    public void testFindSearchedFile(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("testFile.txt");
        Files.createFile(tempFile);

        projectGenerator.findSearchedFile(tempDir.toString(), "testFile.txt");

        assertTrue(Files.exists(tempFile));
    }

    @Test
    public void testPrintDirectoryContent(@TempDir Path tempDir) throws IOException {
        // Prepare the temp directory with sample content.
        Path newDir1 = tempDir.resolve("newDir1");
        Files.createDirectory(newDir1);

        Path newDir2 = tempDir.resolve("newDir2");
        Files.createDirectory(newDir2);

        Path newFile = tempDir.resolve("newFile.txt");
        Files.createFile(newFile);

        // Capture the standard output.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the method 'printDirectoryContent' to test.
        projectGenerator.printDirectoryContent(tempDir.toString());

        // Reset the standard output
        System.setOut(System.out);

        // Format and compare the output.
        String[] outputLines = outContent.toString().trim().split(System.lineSeparator());
        assertEquals(3, outputLines.length);
        assertTrue(Arrays.asList(outputLines).contains("newDir1"));
        assertTrue(Arrays.asList(outputLines).contains("newDir2"));
        assertTrue(Arrays.asList(outputLines).contains("newFile.txt"));
    }

    @Test
    public void testDeleteFile(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("testFile.txt");
        Files.createFile(tempFile);

        projectGenerator.deleteFile(tempDir.toString(), "testFile.txt");

        assertTrue(!Files.exists(tempFile));
    }

    @Test
    public void showFileSizeTest(@TempDir Path tempdir) throws IOException {
        String fileName = "testFileSize.txt";
        Path testFile = tempdir.resolve(fileName);

        String fileContent = "Test for file size.";
        Files.write(testFile, fileContent.getBytes());

        long expectedSize = Files.size(testFile);


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the showFileSize method.
        projectGenerator.showFileSize(testFile.toString());

        // Reset the standard output to its original state.
        System.setOut(System.out);

        String expectedOutput = "File size is: " + expectedSize + " bytes";
        assertTrue(outContent.toString().trim().contains(expectedOutput));
    }
}