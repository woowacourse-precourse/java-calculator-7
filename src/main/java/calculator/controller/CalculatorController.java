package calculator.controller;

import calculator.service.CalculateService;
import calculator.service.SeparatorService;
import calculator.service.ValueService;
import calculator.service.NumberService;
import calculator.view.InputView;

public class CalculatorController {

    public static void calculate(){
        String userInput = InputView.scanString();
        ValueService.saveUserInput(userInput);
        if(ValueService.isEmpty()){
            System.out.println("결과 : " + 0);
        }else{
            SeparatorService.makeUpSeparators();
            ValueService.separateInputString();
            NumberService.extractNum();
            int result = CalculateService.calc();
            System.out.println("결과 : " + result);
        }
    }
}
