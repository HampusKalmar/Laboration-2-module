package com.projectgenerator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class ProjectGeneratorModuleTest {
    private ProjectGeneratorModel projectModel;

    @BeforeEach
    public void setup() {
        projectModel = new ProjectGeneratorModel();
    }

    @Test
    public void checkFileWithContentTest(@TempDir Path tempDir) throws IOException {
        String fileName = "testFile.txt";
        String content = "Hello, Test!";
        
        projectModel.checkFileWithContent(tempDir.toString(), fileName, content);

        Path file = tempDir.resolve(fileName);
        assertTrue(Files.exists(file));
        assertEquals(content, Files.readString(file));
    }

    @Test
    public void checkPathTest(@TempDir Path tempDir) throws IOException {
        String fileName = "testFile.txt";
        String content = "Hello, Test!";
        
        projectModel.checkFileWithContent(tempDir.toString(), fileName, content);
        
        Path file = tempDir.resolve(fileName);
        assertTrue(Files.exists(file));
        assertEquals(content, Files.readString(file));
    }

    @Test
    public void checkDirectoryTest(@TempDir Path tempDir) throws IOException {
        String directoryName = "testDir";
        projectModel.checkDirectory(tempDir.resolve(directoryName).toString());

        assertTrue(Files.exists(tempDir.resolve(directoryName)));
        
        assertThrows(RuntimeException.class, () -> projectModel.checkDirectory(tempDir.resolve(directoryName).toString()));
    }

    @Test
    public void searchFileTest() {

    }

    @Test
    public void listDirectoryContentTest() {

    }

    @Test
    public void findFileTest() {

    }

    @Test
    public void fetchFileSizeTest() {

    }
}
