package Cryptanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Encoder extends Cryptographer {
    @Override
    protected Character getShiftedSymbol(char currentSymbolInLine, int key) {
        Character shiftedSymbol;
        shiftedSymbol = getAlphabet().get((getAlphabet().indexOf(currentSymbolInLine) + key) % getAlphabet().size());
        return shiftedSymbol;
    }

    @Override
    public List<String> makeSymbolShiftInText(List<String> initialText, int key) {
        List<String> shiftedText = new ArrayList<>();

        for (String currentLine : initialText) {
            StringBuilder shiftedLine = new StringBuilder();

            for (int i = 0; i < currentLine.length(); i++) {
                char currentSymbolInLine = currentLine.charAt(i);
                char shiftedSymbol;

                if (getAlphabet().contains(currentSymbolInLine)) {
                    shiftedSymbol = getShiftedSymbol(currentSymbolInLine, key);
                    shiftedLine.append(shiftedSymbol);
                } else {
                    shiftedLine.append(currentSymbolInLine);
                }
            }
            shiftedText.add(String.valueOf(shiftedLine));
            shiftedLine.delete(0, shiftedLine.length());
        }
        return shiftedText;
    }
}
