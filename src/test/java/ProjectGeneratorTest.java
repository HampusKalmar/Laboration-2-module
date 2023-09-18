import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProjectGeneratorTest {
    private ProjectGenerator projectGenerator;

    @BeforeEach
    public void setup() {
        projectGenerator = new ProjectGenerator();
    }

    @Test
    public void testCreateDirectory(@TempDir Path tempDir) throws IOException {
        projectGenerator.createDirectory(tempDir.toString(), "newDir");

        Path newDir = tempDir.resolve("newDir");
        assertTrue(Files.exists(newDir));
        assertTrue(Files.isDirectory(newDir));
    }

    @Test
    public void testCreateFileWithContent(@TempDir Path tempDir) throws IOException {
        String directoryName = "testDir";
        String fileName = "hello.txt";
        String content = "hello";

        projectGenerator.createDirectory(tempDir.toString(), directoryName);
        Path directoryPath = tempDir.resolve(directoryName);

        projectGenerator.createFileWithContent(directoryPath.toString(), fileName, content);

        Path newFile = directoryPath.resolve(fileName);
        assertTrue(Files.exists(newFile));
        assertTrue(Files.isRegularFile(newFile));
    }

    @Test
    public void testFindSearchedFile(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("testFile.txt");
        Files.createFile(tempFile);

        ArrayList<String> foundFiles = projectGenerator.findSearchedFile(tempDir.toString(), "testFile.txt");

        assertEquals(1, foundFiles.size());
        assertEquals("testFile.txt", foundFiles.get(0));
    }
}