package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    public void outputResult(Calculator calculator) {
        System.out.println("결과 : " + calculator.getSum());
    }
}
