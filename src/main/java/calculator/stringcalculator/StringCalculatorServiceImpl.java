package calculator.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    @Override
    public void validateInputForm(String input) {
        if (input.matches("//(.*)\\n(.*)$") || input.matches("^[0-9:,]*$")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String calculate(String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(";", ","));

        String delimiter =  extractDelimiter(input);
        delimiters.add(delimiter);

        String[] stringNumbers = extractNumber(input, delimiters);

        String result = addStringNumbers(stringNumbers);

        return result;
    }

    @Override
    public String extractDelimiter(String input) {
        String delimiter = "";
        if(input.matches("//(.*)\\n(.*)$")) {
            Pattern pattern = Pattern.compile("//(.*)\\n(.*)$");
            Matcher matcher = pattern.matcher(input);

            delimiter = matcher.group(1);
        }

        return delimiter;
    }

    @Override
    public String[] extractNumber(String input, List<String> delimiters) {
        String str = input;

        if(input.matches("//(.*)\\n(.*)$")) {
            Pattern pattern = Pattern.compile("//(.*)\\n(.*)$");
            Matcher matcher = pattern.matcher(input);
            str = matcher.group(2);
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
    public String addStringNumbers(String[] stringNumbers) {
        String result = "";

        return result;
    }

}
