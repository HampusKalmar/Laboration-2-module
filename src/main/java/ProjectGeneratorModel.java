import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class ProjectGeneratorModel {

    /**
     * Creates a file with the content inside the file. 
     *
     * @param fileName The name of the file.
     * @param content The content of the file.
     */
    public void createFileWithContent(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Created a file with the content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks the path of the created directory. 
     *
     * @param path The path where the directory is located.
     * @throws IOException Throws a I/O exception if a path does not exist or is not a directory.
     */
    public void checkPath(String path) throws IOException {
        File directory = new File(path);
        
        if (!directory.exists()) {
            throw new IOException("The specified path does not exist: " + path);
        }

        if (!directory.isDirectory()) {
            throw new IOException("The specified path is not a directory: " + path);
        }
    }

    /**
     * Creates a directory for the user with a name. 
     *
     * @param userDirectory The directory the user created.
     * @throws IOException Throws a I/O exception if a directory could not be created.
     */
    public void createDirectory(String userDirectory) throws IOException {
        File directory = new File(userDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("Created directory named: " + userDirectory);
        } else {
            throw new IOException("Failed to create directory: " + userDirectory);
        }
    }
}