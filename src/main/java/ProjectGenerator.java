import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProjectGenerator implements ProjectGeneratorAPI {
    private final ProjectGeneratorModel projectModel = new ProjectGeneratorModel();
    private String directoryPath;
    private String directoryName;
    private String fileName;
    private String content;
    private static ArrayList<String> foundFiles = new ArrayList<>();

    /**
     * Default constructor for ProjectGenerator class.
     */
    public ProjectGenerator() {}

    public void createDirectory(String directoryPath, String directoryName) throws IOException {
        String fullDirectoryPath = Paths.get(directoryPath, directoryName).toString();
        projectModel.checkPath(directoryPath);
        projectModel.checkDirectory(fullDirectoryPath);
    }

    public void createFileWithContent(String fileName, String content) throws IOException {
        this.fileName = fileName;
        this.content = content;
        projectModel.checkFileWithContent(this.fileName, this.content);
    }

    public ArrayList<String> findSearchedFile(String directoryPath, String fileName) throws IOException {
        return projectModel.searchFile(directoryPath, fileName);
    }

    public void printFoundFile(ArrayList<String> foundFile) throws IOException {
        for (String file : foundFile) {
            System.out.println("Found file: " + file);
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
            project.createDirectory("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "testProj");
            project.createFileWithContent("index.js", "console.log('Hello')");
            // foundFiles = project.findSearchedFile("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", ".gitignore");
            project.printFoundFile(foundFiles);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}