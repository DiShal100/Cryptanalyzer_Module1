package Cryptanalyzer;

public class Menu {
    private static boolean exit = false;

    public static void showMenu() {

        System.out.print("\n\n" +
                "\t\t\t\t\t\t   ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮  \n" +
                "\t\t\t\t\t\t ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮\n" +
                "\t\t\t\t\t\t ✮ ✮                                                        ✮ ✮\n" +
                "\t\t\t\t\t\t   ✮ ✮  Добро пожаловать в программу \'Криптоанализатор\'!  ✮ ✮\n" +
                "\t\t\t\t\t\t ✮ ✮                                                        ✮ ✮\n" +
                "\t\t\t\t\t\t ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮\n" +
                "\t\t\t\t\t\t   ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮ ✮  \n\n" +
                "\t\t\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                "\t\t\t\t┃ Выберите один из пунктов меню:                                             ┃\n" +
                "\t\t\t\t┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n" +
                "\t\t\t\t┃ (1) -> Шифровка текста с помощью ключа                                     ┃\n" +
                "\t\t\t\t┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n" +
                "\t\t\t\t┃ (2) -> Расшифровка текста с помощью ключа                                  ┃\n" +
                "\t\t\t\t┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n" +
                "\t\t\t\t┃ (3) -> Расшифровка текста с помощью brute force (перебор всех вариантов)   ┃\n" +
                "\t\t\t\t┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n" +
                "\t\t\t\t┃ (4) -> Выход                                                               ┃\n" +
                "\t\t\t\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n\n\t\t\t\t\t");

        while (!exit) {

            int menuItemIndex = Validator.menuItemIndexValidation();

            switch (menuItemIndex) {
                case 1 -> startEncode();
                case 2 -> startDecode();
                case 3 -> startDecodeByBruteForce();
                case 4 -> exit();
            }

            System.out.println("\t\t\t\t\t\t\t\t\t" +
                    "" +
                    "꧁ Выход из программы ꧂\n\n" +
                    "\t\t\t\t\t\t\t\t\t\t꧁ До свидания! ꧂");
        }
    }


    private static void startEncode() {
        Cryptographer encoder = new Encoder();
        System.out.println("\t\t\t\t\t\t\t\t\uD83D\uDD11Для шифрования текста введите цифровой ключ");
        encoder.startCryptographicOperation();
        System.out.println("\t\t\t\t\t\t\t\t꧁ Файл успешно зашифрован! ꧂\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD10");
        exit();
    }


    private static void startDecode() {
        Cryptographer decoder = new Decoder();
        System.out.println("\t\t\t\t\t\t\t\t\uD83D\uDD11Для расшифровки текста введите цифровой ключ");
        decoder.startCryptographicOperation();
        System.out.println("\t\t\t\t\t\t\t\t꧁ Файл успешно расшифрован! ꧂\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD13");
        exit();
    }

    private static void startDecodeByBruteForce() {
        Cryptographer bruteForce = new BruteForce();
        int correctKey = bruteForce.startCryptographicOperation();
        System.out.println("\t\t\t\t\t\t\t\t꧁ Файл успешно расшифрован при значении ключа = " + correctKey + " ꧂\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD13");
        exit();
    }

    private static void exit() {
        Menu.exit = true;
    }
}


