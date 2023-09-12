import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ProjectGeneratorImpl implements ProjectGenerator {

    @Override
    public void createFolderStructure(String path, String projectName) throws IOException {
        
    }

    @Override
    public void createFileStructure (String path, String content, String fileName) throws IOException {
        String fullPath = path + "/" + fileName;
        File file = new File(fullPath);
        if (file.createNewFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
                System.out.println("Created " + fileName + "at " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
       ProjectGeneratorImpl projectGen = new ProjectGeneratorImpl();
       projectGen.createFileStructure("", "console.log('Hello world')", "index.js");
    }
}