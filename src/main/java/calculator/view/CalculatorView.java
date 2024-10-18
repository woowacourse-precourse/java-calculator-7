package calculator.view;

import calculator.model.Calculator;

public class CalculatorView {
    public String displayOutput(Calculator calculator) {
        int sum = calculator.getSum();
        String output = "결과 : " + sum;
        System.out.println(output);
        return output;
    }
}
