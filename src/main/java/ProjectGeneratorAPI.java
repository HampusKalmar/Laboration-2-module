import java.io.IOException;

public interface ProjectGeneratorAPI {
    void createDirectory(String directoryPath, String directoryName) throws IOException;
    void createFileWithContent(String fileName, String content) throws IOException;
}
