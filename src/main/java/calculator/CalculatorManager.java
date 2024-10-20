package calculator;

import java.util.List;

public class CalculatorManager {
    public Double plus(List<Double> numberList) {
        Double sum = 0.0;
        for (Double d : numberList) {
            sum += d;
        }
        return sum;
    }
}
