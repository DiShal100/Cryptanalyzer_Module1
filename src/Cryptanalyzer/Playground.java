package Cryptanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Playground {

    public static void main(String[] args) throws IOException {
//        List ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
//                'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
//                'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');
//
//        Collections.rotate(ALPHABET, -2);
//
//        for (Object c : ALPHABET) {
//            System.out.print(c + "");
//        }

        boolean isValidKey = false;
        int key;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        key = buffer.read();

        while(!isValidKey) {

            System.out.println("Введённый символ это цифра? - " + Character.isDigit(key));

            if(Character.isDigit(key)) {
                break;
            }
        }
    }
}

