import java.io.IOException;
import java.util.ArrayList;

public interface ProjectGeneratorAPI {
    void createDirectory(String directoryPath, String directoryName) throws IOException;
    void createFileWithContent(String fileName, String content) throws IOException;
    ArrayList<String> findSearchedFile(String directoryPath, String fileName) throws IOException;
    void printFoundFiles(ArrayList<String> foundFiles) throws IOException;
}
