package calculator.model;

public class Calculator {
    private static int resultValue=0;

    public int plusCalculator(Numbers numbers){
        for (Number number : numbers.getNumbersValue()) {
            resultValue=resultValue+ number.getValue();
        }
        return resultValue;
    }
}
