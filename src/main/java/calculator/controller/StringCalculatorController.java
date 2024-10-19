package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.input.InputTypeSorter;
import calculator.view.InputView;
import calculator.view.ResultView;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorController {
    public static void startStringCalculator() {
        InputView.promptForAdditionInput();

        ResultView.promptForAdditionResult(
                Calculator.addition(
                        InputTypeSorter.sort(
                                Console.readLine()
                        ).createCalculationInputs()
                )
        );
    }
}
