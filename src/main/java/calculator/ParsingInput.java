package calculator;

import calculator.exception.InputValidationException;

public class ParsingInput {
    public static int[] executeParsingInput(String input, String token) {
        String[] splitInput = splitAsToken(input, token);
        return parseIntArray(splitInput);
    }

    private static String[] splitAsToken(String input, String token){
        if (token.equals("[,:]")) {
            return input.split(token);
        }
        return input.substring(input.indexOf("\\n")+2).split(token);
    }

    private static int[] parseIntArray(String[] inputArray) {
        int[] parsedValueArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            int parsedValue = Integer.parseInt(inputArray[i]);
            InputValidationException.isPositiveNumber(parsedValue);
            parsedValueArray[i] = parsedValue;
        }
        return parsedValueArray;
    }
}
