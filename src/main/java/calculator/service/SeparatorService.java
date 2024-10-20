package calculator.service;

import calculator.model.AroundNewSeparator;
import calculator.model.Separator;

public class SeparatorService {
    Separator separator;
    AroundNewSeparator aroundNewSeparator;

    private static final int WRAPPINGSIZE = 5;

    private SeparatorService() {
        separator = Separator.getInstance();
        aroundNewSeparator = AroundNewSeparator.getInstance();
    }

    static private class SingletonHelper {
        static private final SeparatorService INSTANCE = new SeparatorService();
    }

    static public SeparatorService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public String findSeparator(String text) {
        separator.initiateSeparator();

        int startIndex = 0;
        while (checkNewSeparator(startIndex, text)) {
            separator.insertSeparator(text.charAt(startIndex + 2));

            startIndex += WRAPPINGSIZE;
        }

        return text.substring(startIndex);
    }

    private boolean checkNewSeparator(int startIndex, String text) {

        if (startIndex + WRAPPINGSIZE > text.length()) {
            return false;
        }

        for (Integer aroundSeparatorIndex : aroundNewSeparator.getKeys()) {
            char textCharacter = text.charAt(startIndex + aroundSeparatorIndex);
            char checkCharacter = aroundNewSeparator.getValue(aroundSeparatorIndex);

            if (textCharacter != checkCharacter) {
                return false;
            }
        }

        return true;
    }
}
