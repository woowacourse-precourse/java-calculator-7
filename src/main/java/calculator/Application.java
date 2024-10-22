package calculator;

import calculator.domain.Calculator;
import calculator.ui.InputView;
import calculator.ui.ResultView;


public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView.inputView());
        ResultView.calculatorResult(calculator.sum());


    }
}
