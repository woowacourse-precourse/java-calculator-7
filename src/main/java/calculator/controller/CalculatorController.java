package calculator.controller;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorController {

    public void run() throws IOException {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        while (true) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            Console.readLine();
            String input = Console.readLine();
            Calculator calculator = new Calculator();
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            CalculatorService service = new CalculatorService(calculator, exceptionHandler);
            service.getInputValues(input);
            service.validateInput();
            service.sumOfList();
            service.printResult();
        }
    }


}
