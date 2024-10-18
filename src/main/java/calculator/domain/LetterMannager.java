package calculator.domain;

import static calculator.global.constant.Config.*;
import static calculator.global.util.Validator.validateCustomIndex;


public class LetterMannager {
    private StringBuilder letters;

    public LetterMannager(String letters) {
        this.letters = new StringBuilder(letters);
    }

    public void splitCustomSeparator() {
        int startIndex = 0;
        int endIndex = 0;
        String separatorString;
        while (true) {
            startIndex = getStartIndex(START_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            endIndex = getStartIndex(END_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            if (!isFindCustomSeparator(startIndex)) {
                return;
            }
            validateCustomIndex(startIndex, endIndex);
        }
    }

    private int getStartIndex(String letter, int startIndex) {
        return letters.indexOf(letter, startIndex);
    }

    private boolean isFindCustomSeparator(int startIndex) {
        return startIndex != -1;
    }


}
