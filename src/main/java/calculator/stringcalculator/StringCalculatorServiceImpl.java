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


        return "";
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
        return new String[]{""};
    }

    @Override
    public void validateInputDelimiter(String[] stringNumbers) {

    }

    @Override
    public String addStringNumbers(String[] stringNumbers) {
        String result = "";

        return result;
    }

}
