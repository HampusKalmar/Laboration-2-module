import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * ProjectGenerator is responsible for managing various file and directory operations.
 */
public class ProjectGenerator implements ProjectGeneratorAPI {
    private final ProjectGeneratorModel projectModel = new ProjectGeneratorModel();
    private String directoryPath;
    private String fileName;
    private String content;

    /**
     * Default constructor for ProjectGenerator class.
     */
    public ProjectGenerator() {}

    /**
     * Creates a new directory at the specified path.
     *
     * @param directoryPath The path where the directory will be created.
     * @param directoryName The name of the new directory.
     * @throws IOException If an I/O error occurs.
     */
    public void createDirectory(String directoryPath, String directoryName) throws IOException {
        String fullDirectoryPath = Paths.get(directoryPath, directoryName).toString();
        projectModel.checkPath(directoryPath);
        projectModel.checkDirectory(fullDirectoryPath);
    }

    /**
     * Creates a new file with content at the specified directory path.
     *
     * @param directoryPath The directory where the file will be created.
     * @param fileName The name of the file to be created.
     * @param content The content to be written to the file.
     * @throws IOException If an I/O error occurs.
     */
    public void createFileWithContent(String directoryPath, String fileName, String content) throws IOException {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        this.content = content;
        projectModel.checkFileWithContent(this.directoryPath, this.fileName, this.content);
    }

    /**
     *  Searches for a file by name in the specified directory and then prints the file if it exist.
     *
     * @param directoryPath The directory where to search for the file.
     * @param fileName The name of the file to search for.
     * @throws IOException If an I/O error occurs.
     */
    public void findSearchedFile(String directoryPath, String fileName) throws IOException {
        ArrayList<String> foundFiles = projectModel.searchFile(directoryPath, fileName);
          for (String file : foundFiles) {
            System.out.println("Found file: " + file);
        }
    }

    /**
     * Prints the content of a specified directory to the console.
     *
     * @param directoryPath The file path of the directory whose contents are to be printed.
     * @throws IOException If an I/O error occurs.
     */
    public void printDirectoryContent(String directoryPath) throws IOException {
        ArrayList<String> directoryContent = projectModel.listDirectoryContent(directoryPath);
        for (String content : directoryContent) {
            System.out.println(content);
        }
    }

    /**
     * Deletes the file the user has specified.
     *
     * @param directoryPath The directory path to the file that will be deleted.
     * @param fileName The name of the file that will be deleted.
     * @throws IOException If an I/O error occurs.
     */
    public void deleteFile(String directoryPath, String fileName) throws IOException {
        boolean fileExist = projectModel.findFile(directoryPath, fileName);
        if (fileExist) {
            Files.delete(Paths.get(directoryPath, fileName));
        } else {
            throw new IOException("File does not exist: " + fileName);
        }
    }
}