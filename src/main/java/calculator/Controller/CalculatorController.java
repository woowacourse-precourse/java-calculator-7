package calculator.Controller;


import calculator.Service.CalculatorService;

public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService();
    public void calculator_start(){
        String input=calculatorService.Input_String_to_add();
        calculatorService.add(input);
    }

}
