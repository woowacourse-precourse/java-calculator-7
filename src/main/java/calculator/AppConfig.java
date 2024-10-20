package calculator;

public class AppConfig {
    public static Calculator createCalculator() {
        InputValidator inputValidator = new InputValidator();
        NumberSplitter numberSplitter = new NumberSplitter();
        SumCalculator sumCalculator = new SumCalculator();
        return new Calculator(inputValidator, numberSplitter, sumCalculator);
    }
}
