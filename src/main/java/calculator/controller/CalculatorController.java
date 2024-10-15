package calculator.controller;

import calculator.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private Calculator calculator = new Calculator();

    public void start(){
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String s = Console.readLine();
        List<String> validNumber = calculatorService.findValidNumber(s);
        long result = calculator.calculatePlusNumber(validNumber);
        System.out.println("결과 : " + result);
    }

}
