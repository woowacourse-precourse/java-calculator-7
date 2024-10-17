package calculator.util;

import calculator.exception.CalculatorErrorMessage;
import calculator.exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConverter {

    private static String CONTINUOUS_REGEX = "{2,}";
    public static List<Integer> convert(String extractedInput) {
        String[] delimiterAndInput = extractedInput.split(" ");

        if(delimiterAndInput.length == 1){
            return new ArrayList<>();
        }

        String delimiter = delimiterAndInput[0];
        String input = delimiterAndInput[1];

        isValidateDelimiter(delimiter, input);

        String[] letters = input.split(delimiter);
        List<Integer> convertedNumber = new ArrayList<>();

        for(String letter : letters){
            int number = convertToInt(letter);

            isPositiveNumber(number);

            convertedNumber.add(number);
        }

        return convertedNumber;
    }

    private static int convertToInt(String letter) {
        try {
            return Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new CalculatorException(CalculatorErrorMessage.INVALID_LETTER_ERROR);
        }
    }

    private static void isPositiveNumber(int number){
        if(number <= 0){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private static void isValidateDelimiter(String delimiter, String input) {
        StringBuilder delimiterBuilder = new StringBuilder();
        String[] splitDelimiter = delimiter.split("|");

        delimiterBuilder.append(splitDelimiter[0]).append(CONTINUOUS_REGEX)
                .append("|").append(splitDelimiter[1]).append(splitDelimiter[1]).append(CONTINUOUS_REGEX);

        if(splitDelimiter.length == 3){
            delimiterBuilder.append("|").append(splitDelimiter[2]).append(CONTINUOUS_REGEX);
        }

        if(findContinuousDelimiter(input, delimiterBuilder.toString())){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_CONTINUOUS_DELIMITER_ERROR);
        }
    }

    private static boolean findContinuousDelimiter(String continuousRegex, String input){
        Pattern pattern = Pattern.compile(continuousRegex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            return true;
        }

        return false;
    }
}
