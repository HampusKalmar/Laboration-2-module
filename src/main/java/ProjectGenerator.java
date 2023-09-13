import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ProjectGenerator {


    public static void main(String[] args) throws IOException {
        ProjectGeneratorModel projectModel = new ProjectGeneratorModel();
        projectModel.createTheFile("index.js");
    }
}