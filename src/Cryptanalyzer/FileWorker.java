package Cryptanalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWorker {
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

    public List<String> readFileContents(FileWorker filePath) throws IOException{
        List<String> initialText;
        initialText = Files.readAllLines(filePath.getPathSourceFile(), StandardCharsets.UTF_8);
        return initialText;
    }
    public void writeContentToFile(FileWorker filePath, List<String> shiftedText) throws IOException {
        Files.write(filePath.getPathDestinationFile(), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(filePath.getPathDestinationFile(), shiftedText, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
    }
}
