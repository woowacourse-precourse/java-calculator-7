package calculator;

public class OutputHandler {

    private static final String CALCULATION_RESULT = "결과 : %s";

    public void printCalculationResult(String result) {
        System.out.printf(CALCULATION_RESULT, result);
    }
}