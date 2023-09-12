public interface ProjectGenerator {
    boolean createFolderStructure(String path, String projectName);
    boolean createFileStructure(String path, String fileName);
}