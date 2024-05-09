package Cryptanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Decoder extends Cryptographer {
    @Override
    public List<String> makeSymbolShift(List<String> initialText, int key) {
        StringBuilder shiftedLine = new StringBuilder();
        List<String> shiftedText = new ArrayList<>();

        for (String currentLine : initialText) {
            for (int i = 0; i < currentLine.length(); i++) {
                char currentSymbolInLine = currentLine.charAt(i);
                char shiftedSymbol;

                if (getAlphabet().contains(currentSymbolInLine)) {
                    shiftedSymbol = (char) getAlphabet().get((getAlphabet().indexOf(currentSymbolInLine) - key + getAlphabet().size()) % getAlphabet().size());
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
