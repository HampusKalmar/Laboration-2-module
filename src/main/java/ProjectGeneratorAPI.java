import java.io.IOException;
import java.util.ArrayList;

public interface ProjectGeneratorAPI {
    void createDirectory(String directoryPath, String directoryName) throws IOException;
    void createFileWithContent(String directoryPath, String fileName, String content) throws IOException;
    ArrayList<String> findSearchedFile(String directoryPath, String fileName) throws IOException;
    void printFoundFile(ArrayList<String> foundFile) throws IOException;
    void printDirectoryContent(String directoryPath) throws IOException;
}
