package calculator.model;

import static calculator.validate.Validator.validateNumber;

public class Calculator {

    private long result;
    private final Extractor extractor;

    public Calculator() {
        this.extractor = new Extractor();
    }

    public void calculateSum(String input) {
        String[] numbers = extractor.extractNumber(input);
        for (String number : numbers) {
            validateNumber(number);
            result += new Parser(number).parseToLong(number);
        }
    }

    public long getResult() {
        return result;
    }
}
