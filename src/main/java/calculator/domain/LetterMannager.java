package calculator.domain;

import static calculator.global.constant.Config.*;
import static calculator.global.util.Validator.validateCustomIndex;

import calculator.domain.letter.Separators;


public class LetterMannager {
    private final StringBuilder letters;
    private final Separators separators;

    public LetterMannager(String letters) {
        this.letters = new StringBuilder(letters);
        separators = new Separators();
    }

    public void splitCustomSeparator() {
        int startIndex = 0;
        int endIndex;
        String separator;
        while (true) {
            startIndex = getStartIndex(START_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            endIndex = getStartIndex(END_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            if (!isFindCustomSeparator(startIndex)) {
                return;
            }
            validateCustomIndex(startIndex, endIndex);
            separator = subLetter(startIndex, endIndex);
            replaceSeparateLetter(startIndex, endIndex, separator);
            separators.addSeparator(separator);
        }
    }

    private int getStartIndex(String letter, int startIndex) {
        return letters.indexOf(letter, startIndex);
    }

    private boolean isFindCustomSeparator(int startIndex) {
        return startIndex != -1;
    }

    private String subLetter(int startIndex, int endIndex) {
        return letters.substring(startIndex + START_OF_CUSTOM_SEPARATOR_LETTER.length(), endIndex);
    }

    private void replaceSeparateLetter(int startIndex, int endIndex, String newLetter) {
        letters.replace(startIndex, endIndex + END_OF_CUSTOM_SEPARATOR_LETTER.length() - 1, newLetter);
    }

    public Separators getSeparators() {
        return separators;
    }


}
