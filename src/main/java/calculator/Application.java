package calculator;

import calculator.controller.CalculateApplication;
import calculator.model.Input;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Input input = new Input(InputView.read(), "[,:]", new ArrayList<>());
        int calculateResult = CalculateApplication.doCalculate(input);
        OutputView.printResult(calculateResult);
    }
}
