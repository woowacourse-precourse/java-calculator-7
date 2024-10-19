package calculator.domain;

import static calculator.global.constant.Config.*;
import static calculator.global.util.Validator.validateCustomIndex;
import static calculator.global.util.Validator.validateSeparator;

import calculator.domain.separator.Separators;
import calculator.domain.number.Numbers;
import java.util.ArrayList;
import java.util.List;


public class LetterManager {
    private final StringBuilder letters;
    private final Separators separators;
    private final Numbers numbers;

    public LetterManager(String letters) {
        this.letters = new StringBuilder(letters);
        separators = new Separators();
        numbers = new Numbers();

        RegisterCustomSeparator();
        addSeparatedNumbersToNumbers(splitNumbers());
    }

    private void RegisterCustomSeparator() {
        String[] separators = getCustomSeparatorFromLetters();
        for (String separator : separators) {
            replaceCustomSeparatorToSeparator(separator);
            this.separators.addSeparator(separator);
        }
    }

    private String[] getCustomSeparatorFromLetters() {
        List<String> separators = new ArrayList<>();
        int startIndex = 0;
        while (true) {
            startIndex = getStartIndex(START_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            int endIndex = getStartIndex(END_OF_CUSTOM_SEPARATOR_LETTER, startIndex);
            validateCustomIndex(startIndex, endIndex);
            if (!isFindCustomSeparator(startIndex)) {
                break;
            }
            String separator = extractCustomSeparator(startIndex, endIndex);
            separators.add(separator);
            startIndex = endIndex;
        }
        return separators.toArray(String[]::new);
    }


    private String[] splitNumbers() {
        return getNumbersFromLetters();
    }

    private void addSeparatedNumbersToNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            addSeparatedNumberToNumbers(number);
        }
    }

    private void addSeparatedNumberToNumbers(String number) {
        validateSeparator(number);
        this.numbers.addNumber(number);
    }

    private String[] getNumbersFromLetters() {
        String lettersString = letters.toString();
        String separator = separators.toString();
        return lettersString.split(separator);
    }

    private int getStartIndex(String letter, int startIndex) {
        return letters.indexOf(letter, startIndex);
    }

    private boolean isFindCustomSeparator(int startIndex) {
        return startIndex != -1;
    }

    private String extractCustomSeparator(int startIndex, int endIndex) {
        return letters.substring(startIndex + START_OF_CUSTOM_SEPARATOR_LETTER.length(), endIndex);
    }

    private void replaceCustomSeparatorToSeparator(String customSeparator) {
        String separatorString = START_OF_CUSTOM_SEPARATOR_LETTER + customSeparator + END_OF_CUSTOM_SEPARATOR_LETTER;
        int startIndex = letters.indexOf(separatorString);
        letters.replace(startIndex, separatorString.length(), customSeparator);
    }

    public Separators getSeparators() {
        return separators;
    }

    public Numbers getNumbers() {
        return numbers;
    }


}
