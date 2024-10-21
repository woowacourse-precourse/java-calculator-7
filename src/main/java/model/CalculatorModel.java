package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
    private DelimiterList delimiterList = new DelimiterList();
    private static final String customDelimiterRegex = "^//(.)\\\\n(.*)";
    private NumberList numberList = new NumberList();

    public CalculatorModel() {
        delimiterList.add(',');
        delimiterList.add(':');
    }

    public String checkCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(customDelimiterRegex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            char delimiter = matcher.group(1).charAt(0);
            delimiterList.add(delimiter);
            input = matcher.group(2);
        }

        return input;
    }


    public void filterInput(String input) {
        StringBuilder number = new StringBuilder();

        for (char ch : input.toCharArray()) {
            processChar(ch, number);
        }

        appendNumberList(number);
    }

    private void processChar(char ch, StringBuilder number) {
        if (delimiterList.contains(ch)) {
            appendNumberList(number);
            return;
        }

        if (Character.isDigit(ch)) {
            number.append(ch);
            return;
        }

        throw new IllegalArgumentException("Invalid character in input");
    }

    private void appendNumberList(StringBuilder number) {
        String numberString = number.toString();
        int numberInt = numberString.isBlank() ? 0 : Integer.parseInt(numberString);
        numberList.add(numberInt);
        number.setLength(0);
    }

    public int sumNumber() {
        return numberList.sum();
    }
}
