package calculator.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.domain.Calculator;
import calculator.domain.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorController {

    private Extractor extractor;
    private Calculator calculator;


    public void calculateString() {
        String input = startGame();
        extractor = new Extractor(input);
        calculator = new Calculator(extractor.getNumbers());
        OutputView.printOutputMessage(calculator.calculateNumbersSum());
    }

    public String startGame() {
        InputView.printStartMessage();
        return InputView.readInputString();
    }


}
