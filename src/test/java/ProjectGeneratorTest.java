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
import java.util.ArrayList;
import java.util.Arrays;

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
}