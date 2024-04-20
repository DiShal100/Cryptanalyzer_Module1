package Cryptanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playground {
    private static final List ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    public static void main(String[] args) throws IOException {

//
//        Collections.rotate(ALPHABET, -2);
//
//        for (Object c : ALPHABET) {
//            System.out.print(c + "");
//        }

//        boolean isValidKey = false;
//        int key;
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        key = buffer.read();
//
//        while(!isValidKey) {
//
//            System.out.println("Введённый символ это цифра? - " + Character.isDigit(key));
//
//            if(Character.isDigit(key)) {
//                break;
//            }
//        }
        int key = 5;
        System.out.println("Ключ равен = 5");

//        int currentSymbol = ALPHABET.indexOf(' ');

        int currentSymbol = ALPHABET.indexOf(ALPHABET.get(0));
        System.out.println("Индекс текущего элемента = " + currentSymbol);

        int indexCurrentSymbolMinusKey = currentSymbol - key;
        System.out.println("Индекс текущего элемента 'минус' ключ = " + indexCurrentSymbolMinusKey);

        int indexShiftedSymbol;
        if (indexCurrentSymbolMinusKey < 0) {
            indexShiftedSymbol = ALPHABET.size() - Math.abs(indexCurrentSymbolMinusKey);
        }
        else {
            indexShiftedSymbol = indexCurrentSymbolMinusKey;
        }
        System.out.println("Индекс смещённого элемента = " + indexShiftedSymbol);

    }

}

