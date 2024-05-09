package Cryptanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce extends Decoder {
    @Override
    public Integer startCryptographicOperation() {
        Map<Character, Double> russianReferenceFrequencyMap = getRussianFrequencyMap();
        Map<Character, Double> actualFrequencyMap;
        int correctKey = 0;
        double matchingForCurrentKey;
        double bestMatching = Double.NEGATIVE_INFINITY;

        try {
            UserInput.requestPathUserFile(loadFile);
            initialText = FileWorker.readContentFromFile(loadFile);

            for (int currentKey = 1; currentKey < getAlphabet().size(); currentKey++) {
                shiftedText = makeSymbolShift(initialText, currentKey);

                actualFrequencyMap = calculateFrequencyOfEachLetter(shiftedText);
                matchingForCurrentKey = calculateFrequencyMatch(actualFrequencyMap, russianReferenceFrequencyMap);

                if (matchingForCurrentKey > bestMatching) {
                    correctKey = currentKey;
                    bestMatching = matchingForCurrentKey;
                    FileWorker.writeContentToFile(loadFile, shiftedText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return correctKey;
    }

    private static Map<Character, Double> getRussianFrequencyMap() {
        Map<Character, Double> russianFrequencyMap = new HashMap<>();
        russianFrequencyMap.put('а', 0.07998);
        russianFrequencyMap.put('б', 0.01592);
        russianFrequencyMap.put('в', 0.04533);
        russianFrequencyMap.put('г', 0.01687);
        russianFrequencyMap.put('д', 0.02977);
        russianFrequencyMap.put('е', 0.08483);
        russianFrequencyMap.put('ё', 0.00013);
        russianFrequencyMap.put('ж', 0.0094);
        russianFrequencyMap.put('з', 0.01641);
        russianFrequencyMap.put('и', 0.07367);
        russianFrequencyMap.put('й', 0.01208);
        russianFrequencyMap.put('к', 0.03486);
        russianFrequencyMap.put('л', 0.04343);
        russianFrequencyMap.put('м', 0.03203);
        russianFrequencyMap.put('н', 0.067);
        russianFrequencyMap.put('о', 0.10983);
        russianFrequencyMap.put('п', 0.02804);
        russianFrequencyMap.put('р', 0.04746);
        russianFrequencyMap.put('с', 0.05473);
        russianFrequencyMap.put('т', 0.06318);
        russianFrequencyMap.put('у', 0.02615);
        russianFrequencyMap.put('ф', 0.0267);
        russianFrequencyMap.put('х', 0.00966);
        russianFrequencyMap.put('ц', 0.00486);
        russianFrequencyMap.put('ч', 0.0145);
        russianFrequencyMap.put('ш', 0.00718);
        russianFrequencyMap.put('щ', 0.00361);
        russianFrequencyMap.put('ъ', 0.00037);
        russianFrequencyMap.put('ы', 0.01898);
        russianFrequencyMap.put('ь', 0.01735);
        russianFrequencyMap.put('э', 0.00331);
        russianFrequencyMap.put('ю', 0.00639);
        russianFrequencyMap.put('я', 0.02001);
        return russianFrequencyMap;
    }

    private static Map<Character, Double> calculateFrequencyOfEachLetter(List<String> text) {
        Map<Character, Double> actualFrequencyMap = new HashMap<>();
        int textLength = 0;

        for (String currentString : text) {
            for (char c : currentString.toCharArray()) {
                actualFrequencyMap.put(c, actualFrequencyMap.getOrDefault(c, 0.0) + 1);
                textLength++;
            }
        }

        for (Map.Entry<Character, Double> pairSymbolQuantity : actualFrequencyMap.entrySet()) {
            actualFrequencyMap.put(pairSymbolQuantity.getKey(), pairSymbolQuantity.getValue() / textLength);
        }

        return actualFrequencyMap;
    }

    private static double calculateFrequencyMatch(Map<Character, Double> actualFrequencyMap, Map<Character, Double> referenceFrequencyMap) {
        double match = 0;
        for (int i = 0; i < getAlphabet().size(); i++) {
            char currentSymbol = (char) getAlphabet().get(i);
            double diff = actualFrequencyMap.getOrDefault(currentSymbol, 0.0) - referenceFrequencyMap.getOrDefault(currentSymbol, 0.0);
            match -= diff * diff;
        }
        return match;
    }
}
