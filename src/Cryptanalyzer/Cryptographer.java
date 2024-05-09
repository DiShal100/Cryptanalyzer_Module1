package Cryptanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Cryptographer {
    private static final List ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    protected FileWorker loadFile = new FileWorker();
    protected List<String> initialText = new ArrayList<>();
    protected List<String> shiftedText = new ArrayList<>();
    protected Integer key;

    public static List getAlphabet() {
        return Cryptographer.ALPHABET;
    }

    public Integer startCryptographicOperation() {
        try {
            key = Validator.keyValidation();
            UserInput.requestPathUserFile(loadFile);
            initialText = FileWorker.readContentFromFile(loadFile);
            shiftedText = makeSymbolShift(initialText, key);
            FileWorker.writeContentToFile(loadFile, shiftedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public abstract List<String> makeSymbolShift(List<String> initialText, int key);

}
