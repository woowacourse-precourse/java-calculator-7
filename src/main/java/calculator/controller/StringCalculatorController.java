package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorController {
    public static void startStringCalculator() {
        InputView.promptForAdditionInput();
        String input = Console.readLine();
        ResultView.promptForAdditionResult(StringCalculator.calculate(input));
    }
}
