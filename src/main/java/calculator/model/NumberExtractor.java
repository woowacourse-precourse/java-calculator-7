package calculator.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumberExtractor {
    private final Delimiters delimiters;
    private final Calculator calculator;

    public NumberExtractor(Delimiters delimiters, Calculator calculator) {
        this.delimiters = delimiters;
        this.calculator = calculator;
    }

    public void extractNumber(String inputString) {
        if (!isStartingWithDigit(inputString)) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> splitedStringList = splitByDelimiters(inputString);
        for (String str : splitedStringList) {
            validateNumberString(str);
            int number = Integer.parseInt(str);
            calculator.saveNumber(number);
        }
    }

    private boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }

    private ArrayList<String> splitByDelimiters(String inputString) {
        String delimitersString = createDelimitersString();
        StringTokenizer tokenizer = new StringTokenizer(inputString, delimitersString);
        ArrayList<String> splitedStringList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            splitedStringList.add(tokenizer.nextToken());
        }
        return splitedStringList;
    }

    private String createDelimitersString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimiters.getDelimiters()) {
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
