package calculator.controller;

import calculator.dto.CalculatorDTO;
import calculator.service.CalculatorConfig;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceCustomImpl;
import calculator.view.View;

public class CalculatorController {

    public void run(){
        String userInput = View.getStringFromUser();
        CalculatorDTO calculatorDTO = new CalculatorDTO(userInput);
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        View.printResultToUser(calculatorService.calculate(calculatorDTO));
    }
}
