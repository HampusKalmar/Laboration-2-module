import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class ProjectGeneratorModel {

    /**
     * Creates a file with the content inside the file. 
     *
     * @param fileName The name of the file.
     * @param content The content of the file.
     */
    protected void checkFileWithContent(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
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
    protected void checkPath(String path) throws IOException {
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
    protected void checkDirectory(String userDirectory) throws IOException {
        File directory = new File(userDirectory);
        if (directory.exists()) {
           throw new IOException("Directory already exists: " + userDirectory);
        }
        if (!directory.mkdir()) {
            throw new IOException("Failed to create new directory: " + userDirectory);
        }
    }

    protected ArrayList<String> searchFile(String directoryPath, String fileName) throws IOException {
        ArrayList<String> foundPath = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        for (File file : files) {
            foundPath.addAll(searchFile(file.getAbsolutePath(), fileName));
        }
        return foundPath;
    }
}