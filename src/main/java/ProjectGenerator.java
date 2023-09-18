import java.io.IOException;
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
    private static ArrayList<String> foundFiles = new ArrayList<>();

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
     *  Searches for a file by name in the specified directory.
     *
     * @param directoryPath The directory where to search for the file.
     * @param fileName The name of the file to search for.
     * @return An ArrayList of file names that match the search.
     * @throws IOException If an I/O error occurs.
     */
    public ArrayList<String> findSearchedFile(String directoryPath, String fileName) throws IOException {
        return projectModel.searchFile(directoryPath, fileName);
    }

    /**
     * Prints the names of the files found by the search operation.
     *
     * @param foundFile An ArrayList of file names that were found.
     * @throws IOException If an I/O error occurs.
     */
    public void printFoundFile(ArrayList<String> foundFile) throws IOException {
        for (String file : foundFile) {
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
     * Main method for the ProjectGenerator class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            ProjectGenerator project = new ProjectGenerator();
            //project.createDirectory("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "testProj");
           // project.createFileWithContent("C:/Users/hampu/SKOLA/1dv610/laboration-2-module/testProj", "index.js", "console.log('Hello')");
            // foundFiles = project.findSearchedFile("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", ".gitignore");
            //project.printFoundFile(foundFiles);
            project.printDirectoryContent("C:/Users/hampu/SKOLA/1dv610/laboration-2-module");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}