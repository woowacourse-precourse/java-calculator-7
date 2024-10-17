package calculator.controller;

import calculator.domain.Seperator;
import calculator.validation.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void run(){
        OutputView.printCommand();
        String input=InputView.enterInput();

        input=Validator.validateUserInput(input);
        int result=Seperator.calculate(input);



    }
}
