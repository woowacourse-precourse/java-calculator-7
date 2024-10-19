package calculator.controller;

import calculator.domain.Number;
import calculator.domain.Separator;
import calculator.domain.StringValue;
import calculator.service.CalculateService;
import calculator.service.SeparatorService;
import calculator.service.StringValueService;
import calculator.service.NumberService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void calculate(){
        String userInput = InputView.input();
        StringValue stringValue = StringValueService.saveOriginalString(userInput);
        if(StringValueService.isEmpty(stringValue)){
            OutputView.printResult(0);
        }else{
            Separator separator = SeparatorService.makeUpSeparators(stringValue);
            String[] separatedValue = StringValueService.separateInputString(stringValue,separator);
            Number numbers = NumberService.extractNum(separatedValue);
            int result = CalculateService.calc(numbers);
            OutputView.printResult(result);
        }
    }
}
