import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        String fileName = "testFile.txt";
        String content = "Hello World!";
        projectGenerator.createDirectory(tempDir.toString(), content);
        projectGenerator.createFileWithContent(fileName, content);
        Path filePath = tempDir.resolve("newDir").resolve(fileName);
        assertTrue(Files.exists(filePath));
        String readContent = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        assertEquals(content, readContent);
    }
}