package calculator.domain;

import calculator.domain.delimiters.Delimiters;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 입력된 문자열을 구분자로 나눈 양수의 나열을 정의한 클래스
 * 문자열과 구분자를 매개변수로 받아 생성할 수 있음
 */
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
