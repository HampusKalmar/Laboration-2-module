import java.io.IOException;
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
        this.directoryPath = directoryPath;
        this.directoryName = directoryName;
        projectModel.checkPath(this.directoryPath);
        projectModel.checkDirectory(this.directoryName);
    }

    public void createFileWithContent(String fileName, String content) throws IOException {
        this.fileName = fileName;
        this.content = content;
        projectModel.checkPath(this.directoryPath);
        projectModel.checkFileWithContent(this.fileName, this.content);
    
    }

    public ArrayList<String> findSearchedFile(String directoryPath, String fileName) throws IOException {
        return projectModel.searchFile(directoryPath, fileName);
    }

    public void printFoundFiles(ArrayList<String> foundFiles) throws IOException {
        for (String file : foundFiles) {
            System.out.println(file);
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
            //project.createFileWithContent("index.js", "console.log('Hello')");
            foundFiles = project.findSearchedFile("", "settings.gradle.kts");
            project.printFoundFiles(foundFiles);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}