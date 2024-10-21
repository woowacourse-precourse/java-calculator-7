package calculator.stringcalculator;

public class StringCalculator {

    private final StringCalculatorService stringCalculatorService;

    public StringCalculator(StringCalculatorService stringCalculatorService) {
        this.stringCalculatorService = stringCalculatorService;
    }

    public long operate(String input) {
        stringCalculatorService.validateInputForm(input);
        long result = stringCalculatorService.calculate(input);

        return result;
    }

}
