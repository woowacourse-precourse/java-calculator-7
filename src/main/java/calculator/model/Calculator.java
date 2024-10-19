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
            result += new Parser(number).parseToInt(number);
        }
    }
    
    public int getResult() {
        return result;
    }
}
