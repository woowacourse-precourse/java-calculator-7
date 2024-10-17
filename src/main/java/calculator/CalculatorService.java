package calculator;

public class CalculatorService {

    public char[] removeDelimiterAndToCharArray(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll("[:|,]", "");
        return positiveString.replace(customDelimiter, "");
    }

    public int[] convertStringArrayToIntArray(String[] numbersString) {
        int[] numbersInt = new int[numbersString.length];

        for (int index = 0; index < numbersInt.length; index++) {
            validString(numbersString[index]);
            numbersInt[index] = Integer.parseInt(numbersString[index]);
        }

        return numbersInt;
    }

    public int calculatorNumbers(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            validPositive(number);
            total += number;
        }

        return total;
    }

    private void validString(String str) {
        if(isNumber(str))
            throw new IllegalArgumentException();
    }

    private void validPositive(int number) {
        if (number < 0)
            throw new IllegalArgumentException();
    }

    private boolean isNumber(String str) {
        return !str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}