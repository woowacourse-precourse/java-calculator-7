package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Calculator {

    private String equation;
    private String delimiters;
    private final List<Long> positiveNumbers;
    private String customDelimiter;
    private final String customDelimiterStart;
    private final String customDelimiterEnd;

    Calculator() {
        this.equation = "";
        this.delimiters = "";
        this.positiveNumbers = new ArrayList<>();
        this.customDelimiter = "";
        this.customDelimiterStart = "//";
        this.customDelimiterEnd = "\\n";
    }

    Calculator(String customDelimiterStart, String customDelimiterEnd) {
        this.equation = "";
        this.delimiters = "";
        this.positiveNumbers = new ArrayList<>();
        this.customDelimiter = "";
        this.customDelimiterStart = customDelimiterStart;
        this.customDelimiterEnd = customDelimiterEnd;
    }

    private String readFromConsole() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        } finally {
            Console.close();
        }
        if (input == null || input.isEmpty()) {
            input = "";
        }
        return input;
    }

    private void separateCustomDelimiter() {
        if (equation.startsWith(customDelimiterStart)) {
            int delimEndIndex = equation.lastIndexOf(customDelimiterEnd);
            if (delimEndIndex != -1) {
                customDelimiter = equation.substring(customDelimiterStart.length(), delimEndIndex);
                equation = equation.substring(delimEndIndex + customDelimiterEnd.length());
            }
        }
    }

    private void parseDelimiter() {
        HashSet<String> delimiterSet = new HashSet<>();
        delimiterSet.add(",");
        delimiterSet.add(":");

        customDelimiter.codePoints()
                .forEach(codePoint -> {
                    String character = new String(Character.toChars(codePoint));
                    delimiterSet.add(character);
                });

        StringBuilder sb = new StringBuilder();
        for (String c : delimiterSet) {
            sb.append(c);
        }
        delimiters = sb.toString();
    }

    private boolean isPositiveNumber(String number) {
        String regEx = "\\d*";
        return Pattern.matches(regEx, number);
    }

    private void parsePositiveNumbers() {
        String regEx = "[" + Pattern.quote(delimiters) + "]";
        String[] numbers = equation.split(regEx);

        for (String number : numbers) {
            if (number.isEmpty()) {
                positiveNumbers.add(0L);
            } else if (!isPositiveNumber(number)) {
                throw new IllegalArgumentException();
            } else {
                positiveNumbers.add(Long.parseLong(number));
            }
        }
    }

    private Long sumPositiveNumbers() {
        long sum = 0L;
        for (Long number : positiveNumbers) {
            if (sum > Long.MAX_VALUE - number) {
                throw new NumberFormatException();
            }
            sum += number;
        }
        return sum;
    }

    private void writeToConsole(Long result) {
        System.out.printf("결과 : %d", result);
    }

    public void operate() {
        equation = readFromConsole();
        System.out.println(equation);
        separateCustomDelimiter();
        parseDelimiter();
        parsePositiveNumbers();
        writeToConsole(sumPositiveNumbers());
    }
}
