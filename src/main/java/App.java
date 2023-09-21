import java.io.IOException;
import com.projectgenerator.api.ProjectGeneratorAPI;

public class App {
   /**
     * Main method for the ProjectGenerator class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            ProjectGeneratorAPI project = new ProjectGeneratorAPI();
            //project.createDirectory("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "testProj");
            //project.createFileWithContent("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "index.js", "console.log('Hello')");
            //project.findSearchedFile("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "gradlew");
            //project.printDirectoryContent("C:/Users/hampu/SKOLA/1dv610/laboration-2-module");
            project.deleteFile("C:/Users/hampu/SKOLA/1dv610/laboration-2-module", "TESTRAPPORT.md");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
