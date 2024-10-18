package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberExtractor {
    public Numbers extractNumber(String inputString, Delimiters delimiters) {
        Numbers numbers = new Numbers();
        if (inputString.isBlank()) {
            return numbers;
        }
        if (!isStartingWithDigit(inputString)) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> splitedStringList = splitByDelimiters(inputString, delimiters);
        for (String str : splitedStringList) {
            validateNumberString(str);
            int number = Integer.parseInt(str);
            numbers.saveNumber(number);
        }
        return numbers;
    }

    private boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }

    private ArrayList<String> splitByDelimiters(String inputString, Delimiters delimiters) {
        String delimitersString = createDelimitersString(delimiters);
        StringTokenizer tokenizer = new StringTokenizer(inputString, delimitersString);
        ArrayList<String> splitedStringList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            splitedStringList.add(tokenizer.nextToken());
        }
        return splitedStringList;
    }

    private String createDelimitersString(Delimiters delimiters) {
        List<Character> delimitersList = delimiters.getDelimiters();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimitersList) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void validateNumberString(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
