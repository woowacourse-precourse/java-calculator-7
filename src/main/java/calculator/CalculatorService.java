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

        numberValidator.validateNoDigits(positiveCharArray);
        for (int index = 0; index < positiveArray.length; index++)
            positiveArray[index] = Character.getNumericValue(positiveCharArray[index]);

        return numbersInt;
    }

    public int calculatorNumbers(int[] numbers) {
        int total = 0;

        numberValidator.validatorNoNegatives(numbers);
        for (int number : numbers)
            total += number;
        }

        return total;
    }



}