package calculator.domain;

import calculator.domain.separator.Separators;

public class NumberSplitter {

    public String[] getNumbersFromLetters(String letters, Separators separators) {
        String separator = separators.toString();
        return letters.split(separator);
    }
}
