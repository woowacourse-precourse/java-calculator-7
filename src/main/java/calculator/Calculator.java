package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class Calculator {

    private String equation;
    private String delimiters;
    private String customDelimiter;
    private final String customDelimiterStart;
    private final String customDelimiterEnd;

    Calculator() {
        this.equation = "";
        this.customDelimiter = "";
        this.customDelimiterStart = "//";
        this.customDelimiterEnd = "\\n";
    }

    Calculator(String customDelimiterStart, String customDelimiterEnd) {
        this.equation = "";
        this.customDelimiter = "";
        this.customDelimiterStart = customDelimiterStart;
        this.customDelimiterEnd = customDelimiterEnd;
    }

    private String readFromConsole() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input == null) {
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
        HashSet<Character> delimiterSet = new HashSet<>();
        delimiterSet.add(',');
        delimiterSet.add(':');

        for (char c : customDelimiter.toCharArray()) {
            delimiterSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : delimiterSet) {
            sb.append(c);
        }
        delimiters = sb.toString();
    }

    public void operate() {
        equation = readFromConsole();
        separateCustomDelimiter();
        parseDelimiter();
    }
}
