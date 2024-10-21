package calculator.domain;

import calculator.domain.delimiters.Delimiters;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class NumericSequence {

    private final List<Integer> integers;

    private NumericSequence(List<Integer> integers) {
        this.integers = integers;
    }

    public static NumericSequence getOfStringAndDelimiters(InputtedString inputtedString,
                                                           Delimiters delimiters) {
        String line = inputtedString.getLine();
        String[] numbers = getArraysOfLineSplitByDelimiters(line, delimiters);
        List<Integer> sequence = Arrays.stream(numbers)
                .filter(digit -> !digit.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        return new NumericSequence(sequence);
    }

    private static String[] getArraysOfLineSplitByDelimiters(String line,
                                                             Delimiters delimiters) {
        String lineWithOutCustomDelimiterSpecifierPart =
                delimiters.getStringWithOutCustomDelimiterSpecifierPart(line);
        String regexDelimiters = delimiters.getRegex();
        Pattern patternDelimiters = Pattern.compile(regexDelimiters);
        return patternDelimiters.split(lineWithOutCustomDelimiterSpecifierPart);
    }

    public int getTotalSum() {
        return integers.stream().reduce(0, Integer::sum);
    }
}
