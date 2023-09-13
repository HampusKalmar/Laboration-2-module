import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class ProjectGeneratorModel {

    /**
     * 
     * @param fileName
     * @throws IOException
     */
    public void createEmptyFile(String fileName) {
        try (FileWriter filewriter = new FileWriter(fileName)) {
            System.out.println("Created empty file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 
     * @param content
     * @param fileName
     * @throws IOException
     */
    public void createContent(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(content))) {
            writer.write(content);
            System.out.println("The file contains: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param path
     * @throws IOException
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
     * 
     * @param path
     * @throws IOException
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