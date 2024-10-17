package calculator;

import calculator.controller.CalculateApplication;
import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        InputString inputString = new InputString(InputView.input(), "[,:]", new ArrayList<>());

        int calculateResult = CalculateApplication.run(inputString);

        OutputView.printResult(calculateResult);
    }
}
