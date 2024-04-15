package Cryptanalyzer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        boolean exit = false;

        System.out.print("\n\n" +
                "\t\t\t\t\t\t * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
                "\t\t\t\t\t\t * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
                "\t\t\t\t\t\t * *  Добро пожаловать в программу \'Криптоанализатор\'!   * *\n" +
                "\t\t\t\t\t\t * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
                "\t\t\t\t\t\t * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n\n" +
                "\t\t\t\t* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
                "\t\t\t\t* Выберите один из пунктов меню:                                            *\n" +
                "\t\t\t\t*                                                                           *\n" +
                "\t\t\t\t* (1) -> Шифровка текста с помощью ключа;                                   *\n" +
                "\t\t\t\t*                                                                           *\n" +
                "\t\t\t\t* (2) -> Расшифровка текста с помощью ключа;                                *\n" +
                "\t\t\t\t*                                                                           *\n" +
                "\t\t\t\t* (3) -> Расшифровка текста с помощью brute force (перебор всех вариантов); *\n" +
                "\t\t\t\t*                                                                           *\n" +
                "\t\t\t\t* (4) -> Выход.                                                             *\n" +
                "\t\t\t\t* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n\t\t\t\t\t");

        Scanner inputIndexMenuItem = new Scanner(System.in);

        while (!exit) {
            int indexMenuItem = inputIndexMenuItem.nextInt();

            switch (indexMenuItem) {
                case 1 -> startEncode();
                case 2 -> startDecode();
                case 3 -> startDecodeByBruteForce();
                case 4 -> exit = true;
            }

            System.out.println("\t\t\t\t\t\t\t\tВыход из программы...\n\n" +
                        "\t\t\t\t\t\t\t\t\tДо свидания!");
        }
    }


    private static void startEncode() {
        boolean isValidKey = false;
        int key;
        try(InputStreamReader input = new InputStreamReader(System.in)) {
            while (!isValidKey) {
                System.out.println("Введите цифровой ключ для шифрования текста...");
                key = input.read();

                if (Character.isDigit(key) && key != 0) {
                    Cryptographer.startEncryptionText(key);
                    isValidKey = true;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void startDecode() {
        boolean isValidKey = false;
        int key;
        try(InputStreamReader input = new InputStreamReader(System.in)) {
            while (!isValidKey) {
                System.out.println("Введите цифровой ключ для расшифровки текста...");
                key = input.read();

                if (Character.isDigit(key) && key != 0) {
                    Cryptographer.startDecryptionText(key);
                    isValidKey = true;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void startDecodeByBruteForce() {
        Cryptographer.startDecryptionTextByBruteForce();
    }
}
