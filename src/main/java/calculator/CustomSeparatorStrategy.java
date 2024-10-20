package calculator;

import calculator.domain.Calculator;

public class CustomSeparatorStrategy implements CalculatorStrategy {

    Calculator calculator = new Calculator();

    public void calculate(String inputText) {
        String customSeparator = calculator.findCustomSeparator(inputText);
        String text = calculator.removeCustomReserveWord(inputText);

        String arr[] = calculator.extractNumber(customSeparator, text);
        Double totalSum = calculator.sum(arr).doubleValue();
        if (checkFloatingPoint(totalSum)) {
            System.out.println("결과 : " + totalSum);
        }
        if (!checkFloatingPoint(totalSum)) {
            System.out.println("결과 : " + totalSum.intValue());
        }
    }

    private Boolean checkFloatingPoint(Double totalSum) {
        if (totalSum.intValue() == totalSum){
            return false;
        }
        return true;
    }
}
