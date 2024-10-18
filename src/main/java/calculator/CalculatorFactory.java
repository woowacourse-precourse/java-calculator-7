package calculator;

public class CalculatorFactory {

    public static CalculatorController createCalculatorController() {
        CalculatorService calculatorService = getCalculatorService();

        return new CalculatorController(calculatorService);
    }

    private static CalculatorService getCalculatorService() {
        return new CalculatorService();
    }
}
