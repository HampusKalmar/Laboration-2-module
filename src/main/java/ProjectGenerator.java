import java.io.IOException;
import java.nio.file.Paths;

public class ProjectGenerator {
    private ProjectGeneratorModel projectModel = new ProjectGeneratorModel();
    private String directoryPath;
    private String userDirectory;
    private String fileName;
    private String content;

    /**
     * Default constructor for ProjectGenerator class.
     */
    public ProjectGenerator() {}

    /**
     * Sets the path of the directory.
     *
     * @param directoryPath The path of the directory.
     */
    private void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    /**
     * Sets the name of the file.
     *
     * @param fileName The name of the file.
     */
    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Sets the name of the directory.
     *
     * @param userDirectory The name of the directory.
     */
    private void setDirectoryName(String userDirectory) {
        this.userDirectory = userDirectory;
    }

    /**
     * Sets the content of the file.
     *
     * @param content What the file contains.
     */
    private void setContent(String content) {
        this.content = content;
    }

    /**
     * Controls the creation of the directory by validating the path and creating the directory.
     *
     * @throws IOException IOException if an I/O error occurs.
     */
    private void controlCreatedDirectory() throws IOException {
        projectModel.checkPath(directoryPath);
        Paths.get(directoryPath, userDirectory).toString();
        projectModel.createDirectory(userDirectory);
    }

    /**
     * Controls the creation of the files by validating the path and creating the file with content.
     *
     * @throws IOException IOException if an I/O error occurs.
     */
    private void controlCreatedFile() throws IOException{
        projectModel.checkPath(directoryPath);
        Paths.get(directoryPath, userDirectory).toString();
        projectModel.createFileWithContent(fileName, content);
    }

    /**
     * Main method for the ProjectGenerator class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            ProjectGenerator project = new ProjectGenerator();
            project.setDirectoryPath("");
            project.setFileName("index.js");
            project.setDirectoryName("testProject");
            project.setContent("console.log('Hello world')");
            project.controlCreatedDirectory();
            project.controlCreatedFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}