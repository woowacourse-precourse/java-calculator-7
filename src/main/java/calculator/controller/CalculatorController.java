package calculator.controller;

import calculator.service.CalculateService;
import calculator.service.SeparatorService;
import calculator.service.ValueService;
import calculator.service.NumberService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void calculate(){
        String userInput = InputView.scanString();
        ValueService.saveUserInput(userInput);
        if(ValueService.isEmpty()){
            OutputView.printResult(0);
        }else{
            SeparatorService.makeUpSeparators();
            ValueService.separateInputString();
            NumberService.extractNum();
            int result = CalculateService.calc();
            OutputView.printResult(result);
        }
    }
}
