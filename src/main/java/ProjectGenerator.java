import java.io.IOException;

public interface ProjectGenerator {
    void createFolderStructure(String path, String projectName) throws IOException;
    void createFileStructure(String path, String content, String type) throws IOException;
}