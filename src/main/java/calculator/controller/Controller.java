package calculator.controller;

import calculator.validation.InputValidate;
import calculator.model.Model;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    public Controller(){
    }
    public void splitAndSum(){
        InputView inputView = new InputView();
        Model model = new Model(inputView.userInput());
        OutputView outputView = new OutputView();
        InputValidate inputValidate = new InputValidate();

        if(model.isValidationCheckNullOrEmpty(model.getUserInput())){
            outputView.printZero();
        }
        inputValidate.stringStartsCheck(model.getUserInput());

        String[] tokens = model.userInputSplit(model.getUserInput());

        inputValidate.checkForNegativeNumbersAndZero(tokens);  // 음수 체크를 문자열 분리 후에 실행

        outputView.printResult(model.calculateSum(tokens));
    }
}
