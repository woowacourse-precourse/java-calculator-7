package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.view.InputView;
import calculator.domain.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(Console.readLine());
        Calculator calculator = new Calculator(inputView.input());
        OutputView outputView = new OutputView(calculator.sum());
        outputView.output();
        Console.close();
    }
}
