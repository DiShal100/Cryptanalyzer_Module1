package Cryptanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Cryptographer {
    private static final List ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public static void startEncryptionText(int key) throws IOException {
        boolean isValidPath = false;
        FileLoader loadFile = new FileLoader();
        Scanner scanner = new Scanner(System.in);

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу с исходным текстом...\n");
            Path initialPath = Path.of(scanner.nextLine());

            if(Files.exists(initialPath) && Files.isRegularFile(initialPath)) {
                loadFile.setPathSourceFile(initialPath);
                isValidPath = true;
            }
        }

        isValidPath = false;

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу для записи зашифрованного текста...\n");
            Path destinationPath = Path.of(scanner.nextLine());

            if(Files.exists(destinationPath) && Files.isRegularFile(destinationPath)) {
                loadFile.setPathDestinationFile(destinationPath);
                isValidPath = true;
            }
        }

        List<String> initialText = Files.readAllLines(loadFile.getPathSourceFile());
        StringBuilder singleLine = new StringBuilder();

        for (String s : initialText) { // собираем список строк в единую строку;
            singleLine.append(s + "\n");
        }



        scanner.close();
    }

    public static void startDecryptionText(int key) {
        boolean isValidPath = false;
        FileLoader loadFile = new FileLoader();
        Scanner scanner = new Scanner(System.in);

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу с зашифрованным текстом...\n");
            Path initialPath = Path.of(scanner.nextLine());

            if(Files.exists(initialPath) && Files.isRegularFile(initialPath)) {
                loadFile.setPathSourceFile(initialPath);
                isValidPath = true;
            }
        }

        isValidPath = false;

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу для записи расшифрованного текста...\n");
            Path destinationPath = Path.of(scanner.nextLine());

            if(Files.exists(destinationPath) && Files.isRegularFile(destinationPath)) {
                loadFile.setPathDestinationFile(destinationPath);
                isValidPath = true;
            }
        }



        scanner.close();
    }

    public static void startDecryptionTextByBruteForce() {
        boolean isValidPath = false;
        FileLoader loadFile = new FileLoader();
        Scanner scanner = new Scanner(System.in);

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу с зашифрованным текстом...\n");
            Path initialPath = Path.of(scanner.nextLine());

            if(Files.exists(initialPath) && Files.isRegularFile(initialPath)) {
                loadFile.setPathSourceFile(initialPath);
                isValidPath = true;
            }
        }

        isValidPath = false;

        while(!isValidPath) {
            System.out.println("\t\t\t\tВведите путь к файлу для записи расшифрованного текста...\n");
            Path destinationPath = Path.of(scanner.nextLine());

            if(Files.exists(destinationPath) && Files.isRegularFile(destinationPath)) {
                loadFile.setPathDestinationFile(destinationPath);
                isValidPath = true;
            }
        }



        scanner.close();
    }
}
