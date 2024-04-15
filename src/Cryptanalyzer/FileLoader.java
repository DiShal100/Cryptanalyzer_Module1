package Cryptanalyzer;

import java.nio.file.Path;

public class FileLoader {
    private Path pathSourceFile;
    private Path pathDestinationFile;

    public Path getPathSourceFile() {
        return pathSourceFile;
    }

    public void setPathSourceFile(Path initialPath) {
        this.pathSourceFile = initialPath;
    }

    public Path getPathDestinationFile() {
        return pathDestinationFile;
    }

    public void setPathDestinationFile(Path destinationPath) {
        this.pathDestinationFile = destinationPath;
    }
}
