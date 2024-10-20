package calculator.controller;

import calculator.domain.Calculator;
import calculator.validator.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class CalculatorController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    Calculator calculator = new Calculator();



    public void run() {
        String input = inputView.readSentence();
        ArrayList<String> separators = calculator.getSeparators();

        //입력값 검증
        if (!validator.validateInput(input, separators)){
            //문자열이 비어있거나 구분자만 있으면 0출력
            outputView.printResult(0);
            return;
        }

        int sum = calculator.sumNumber(input, separators);
        outputView.printResult(sum);
    }
}
