package calculator.domain;

import static calculator.global.constant.Config.*;
import static calculator.global.util.Validator.validateSeparator;

import calculator.domain.separator.Separators;
import calculator.domain.number.Numbers;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        Arrays.stream(separators)
                .forEach(separator -> {
                    replaceCustomSeparatorToSeparator(separator);
                    this.separators.addSeparator(separator);
                });
    }

    private String[] getCustomSeparatorFromLetters() {
        String regex = Pattern.quote(START_OF_CUSTOM_SEPARATOR_LETTER) + "(.*?)" + Pattern.quote(
                END_OF_CUSTOM_SEPARATOR_LETTER);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letters);

        List<String> separators = matcher.results()
                .map(result -> result.group(1))
                .toList();

        return separators.toArray(String[]::new);
    }


    private String[] splitNumbers() {
        return getNumbersFromLetters();
    }

    private void addSeparatedNumbersToNumbers(String[] numbers) {
        Arrays.stream(numbers)
                .filter(number -> !number.isEmpty())
                .forEach(this::addSeparatedNumberToNumbers);
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

    private void replaceCustomSeparatorToSeparator(String customSeparator) {
        String regex = Pattern.quote(START_OF_CUSTOM_SEPARATOR_LETTER) + Pattern.quote(customSeparator) + Pattern.quote(END_OF_CUSTOM_SEPARATOR_LETTER);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letters.toString());
        String result = matcher.replaceAll(customSeparator);
        letters.setLength(0);
        letters.append(result);
    }



    public Separators getSeparators() {
        return separators;
    }

    public Numbers getNumbers() {
        return numbers;
    }


}
