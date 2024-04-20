package Cryptanalyzer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Cryptographer {

    public static void startCryptographicOperation(int key, final int indexOperation) {
        FileWorker loadPath = new FileWorker();
        Desktop desktop = Desktop.getDesktop();
        File file;

        System.out.println("\t\t\t\t\t\t\t\t\uD83D\uDCDCВведите путь к файлу с исходным текстом\n");
        Validator.pathValidation(loadPath, PathType.PATH_TO_SOURCE_FILE);

        System.out.println("\t\t\t\t\t\t\t\t\uD83D\uDCDCВведите путь к файлу для записи зашифрованного текста\n");
        Validator.pathValidation(loadPath, PathType.PATH_TO_DESTINATION_FILE);

        try {
            List<String> initialText = loadPath.readFileContents(loadPath);
            List<String> shiftedText = makeShiftSymbol(initialText, key, indexOperation);
            loadPath.writeContentToFile(loadPath, shiftedText);
            file = loadPath.getPathDestinationFile().toFile();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startDecryptionTextByBruteForce() {

    }

    public static List<String> makeShiftSymbol(List<String> initialText, int key, int indexOperation) {
        StringBuilder shiftedLine = new StringBuilder();
        List<String> shiftedText = new ArrayList<>();

        for (String currentLine : initialText) {
            for (int i = 0; i < currentLine.length(); i++) {
                char currentSymbolInLine = currentLine.charAt(i);

                if (indexOperation == 1) {
                    char shiftedSymbol = (char) (currentSymbolInLine + key);
                    shiftedLine.append(shiftedSymbol);
                } else if (indexOperation == 2) {
                    char shiftedSymbol = (char) (currentSymbolInLine - key);
                    shiftedLine.append(shiftedSymbol);
                }
            }
            shiftedText.add(String.valueOf(shiftedLine));
            shiftedLine.delete(0, shiftedLine.length());
        }
        return shiftedText;
    }
}
