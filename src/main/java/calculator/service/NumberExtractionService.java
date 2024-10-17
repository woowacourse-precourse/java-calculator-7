package calculator.service;


import calculator.model.Numbers;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberExtractionService {
    private final Numbers numbers;
    private final CustomDelimiterService customDelimiterService;

    public NumberExtractionService(Numbers numbers, CustomDelimiterService customDelimiterService) {
        this.numbers = numbers;
        this.customDelimiterService = customDelimiterService;
    }

    protected List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public void extractNumber(String inputString) {
        if (!isStartingWithDigit(inputString)) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> splitedStringList = splitByDelimiters(inputString);
        for (String str : splitedStringList) {
            validateNumberString(str);
            int number = Integer.parseInt(str);
            numbers.saveNumber(number);
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
        List<Character> delimiters = customDelimiterService.getDelimiters();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimiters) {
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
