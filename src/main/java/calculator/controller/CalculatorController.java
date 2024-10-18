package calculator.controller;

import calculator.dto.CalculatorDTO;
import calculator.service.CalculatorConfig;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceCustomImpl;
import calculator.util.ExceptionUtil;
import calculator.view.View;

public class CalculatorController {

    public void run(){
        String userInput = View.getStringFromUser();
        CalculatorDTO calculatorDTO = new CalculatorDTO(userInput);
        ExceptionUtil.checkParameterIsLiteral(calculatorDTO);
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        View.printResultToUser(calculatorService.calculate(calculatorDTO));
    }
}
