package com.projectgenerator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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
    public void searchFileTest(@TempDir Path tempDir) throws IOException {
        String fileName = "testFile.txt";
        Files.createFile(tempDir.resolve(fileName));

        ArrayList<String> result = projectModel.searchFile(tempDir.toString(), fileName);
        assertEquals(1, result.size());
        assertEquals(fileName, result.get(0));
    }

    @Test
    public void listDirectoryContentTest(@TempDir Path tempDir) throws IOException {
        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";
        Files.createFile(tempDir.resolve(fileName1));
        Files.createFile(tempDir.resolve(fileName2));

        ArrayList<String> content = projectModel.listDirectoryContent(tempDir.toString());
        assertTrue(content.contains(fileName1));
        assertTrue(content.contains(fileName2));
    }

    @Test
    public void findFileTest(@TempDir Path tempDir) throws IOException {
        String fileName = "testFile.txt";
        Files.createFile(tempDir.resolve(fileName));

        assertTrue(projectModel.findFile(tempDir.toString(), fileName));
        assertFalse(projectModel.findFile(tempDir.toString(), "nonExistentFile.txt"));
    }

    @Test
    public void fetchFileSizeTest(@TempDir Path tempDir) throws IOException {
        String fileName = "testFile.txt";
        String content = "Hello, Test!";
        Files.writeString(tempDir.resolve(fileName), content);

        long size = projectModel.fecthFileSize(tempDir.resolve(fileName).toString());
        assertEquals(content.length(), size);
    }
}
