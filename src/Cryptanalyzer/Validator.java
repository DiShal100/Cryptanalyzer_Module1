package Cryptanalyzer;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static Integer menuItemIndexValidation() {
        boolean isValidIndex = false;
        String inputLine;
        int ItemIndex = 0;

        while (!isValidIndex) {
            inputLine = UserInput.getUserInput();

            if (inputLine.isEmpty() || inputLine.isBlank()) {
                System.out.println("\t\t\t\t\t\t⚠\uFE0FВведён некорректный номер пункта меню! Ввод не должен быть " +
                        "пустым...");
                continue;
            }
            if (!isDigitKey(inputLine)) {
                System.out.println("\t\t\t\t\t\t⚠\uFE0FВведён некорректный номер пункта меню! Ввод должен содержать целое " +
                        "положительное число от 1 до 4...");
                continue;
            }
            if (Integer.parseInt(inputLine) != 0 && Integer.parseInt(inputLine) <= 4) {
                ItemIndex = Integer.parseInt(inputLine);
                return ItemIndex;
            } else {
                System.out.println("\t\t\t\t\t\t⚠\uFE0FВведён некорректный номер пункта меню! Ввод должен содержать целое " +
                        "положительное число от 1 до 4...");
            }
        }
        return ItemIndex;
    }

    public static Integer keyValidation() {
        boolean isValidKey = false;
        String inputLine;
        int key = 0;

        while (!isValidKey) {
            inputLine = UserInput.getUserInput();

            if (inputLine.isEmpty() || inputLine.isBlank()) {
                System.out.println("\t\t\t\t\t\t⚠\uFE0FВведён некорректный ключ! Ввод не должен быть пустым...");
                continue;
            }
            if (!isDigitKey(inputLine) || (Integer.parseInt(inputLine) < 1
                    || Integer.parseInt(inputLine) >= Cryptographer.getAlphabet().size())) {
                System.out.println("\t\t\t\t\t\t⚠\uFE0FВведён некорректный ключ! Ввод должен содержать целое " +
                        "положительное число от 1 до "
                        + (Cryptographer.getAlphabet().size()-1) + "⚠\uFE0F");
            } else {
                key = Integer.parseInt(inputLine);
                return key;
            }
        }
        return key;
    }

    private static boolean isDigitKey(String key) {
        for (char symbol : key.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static void pathValidation(FileWorker filePath, PathType pathToWhichFile) {
        boolean isValidPath = false;
        String inputLine;
        Path inputPath;

        while (!isValidPath) {
            inputLine = UserInput.getUserInput();
            if (inputLine.isEmpty() || inputLine.isBlank()) {
                System.out.println("\t\t\t\t\t\t\t\t⚠\uFE0FВвод не может быть пустым..." +
                        "Введите корректный путь к файлу...\n");
                continue;
            }

            inputPath = Path.of(inputLine);

            if (!inputPath.isAbsolute()) {
                System.out.println("\t\t\t\t\t\t\t\t⚠\uFE0FВведите абсолютный (полный) путь к файлу...\n");
                continue;
            }
            if (!Files.exists(inputPath) || !Files.isRegularFile(inputPath)) {
                System.out.println("\t\t\t\t\t\t\t\t⚠\uFE0FВведите путь к файлу, который существует...\n");
            } else {
                switch (pathToWhichFile) {
                    case PATH_TO_SOURCE_FILE -> filePath.setPathSourceFile(inputPath);
                    case PATH_TO_DESTINATION_FILE -> filePath.setPathDestinationFile(inputPath);
                }
                isValidPath = true;
            }
        }
    }
}