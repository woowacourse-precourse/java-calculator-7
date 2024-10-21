package calculator.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    @Override
    public void validateInputForm(String input) {
        int startIndex = input.lastIndexOf("//");
        int endIndex = input.lastIndexOf("\\n");
        if (input.charAt(0) == '/') {
            if (startIndex == -1 || endIndex == -1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public long calculate(String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(":", ","));

        String delimiter =  extractDelimiter(input);
        delimiters.add(delimiter);

        String[] stringNumbers = extractNumber(input, delimiters);

        long result = addStringNumbers(stringNumbers);

        return result;
    }

    @Override
    public String extractDelimiter(String input) {
        String delimiter = "";
        if (input.charAt(0) == '/') {
            int startIndex = input.lastIndexOf("//");
            int endIndex = input.lastIndexOf("\\n");
            if (startIndex < endIndex) {
                delimiter = input.substring(startIndex + 2, endIndex).trim();
            }
        }

        return delimiter;
    }

    @Override
    public String[] extractNumber(String input, List<String> delimiters) {
        String str = input;

        if (input.charAt(0) == '/') {
            int startIndex = input.lastIndexOf("\\n");
            str = input.substring(startIndex + 2).trim();

        }

        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < delimiters.size(); i++) {
            if (i < delimiters.size() - 1) {
                regex.append(delimiters.get(i)).append("|");
                continue;
            }
            regex.append(delimiters.get(i));
        }

        String[] stringNumbers = str.split(String.valueOf(regex));
        validateInputDelimiter(stringNumbers);

        return stringNumbers;
    }

    @Override
    public void validateInputDelimiter(String[] stringNumbers) {
        for (String stringNumber : stringNumbers) {
            if (stringNumber.matches("^[0-9]*$")) {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override
    public long addStringNumbers(String[] stringNumbers) {
        long result = 0L;
        for (int i = 0; i < stringNumbers.length; i++) {
            result += Long.parseLong(stringNumbers[i]);
        }

        return result;
    }

}
