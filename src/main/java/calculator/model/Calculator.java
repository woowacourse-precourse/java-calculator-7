package calculator.model;

import static calculator.validate.Validator.validateNumber;

public class Calculator {

    private int result;
    private final Extractor extractor;

    public Calculator() {
        this.extractor = new Extractor();
    }

    public void calculateSum(String input) {
        String[] numbers = extractor.extractNumber(input);
        for (String number : numbers) {
            validateNumber(number);
            int intNumber = getIntNumber(number);
            result += intNumber;
        }
    }

    private static int getIntNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    public int getResult() {
        return result;
    }
}
