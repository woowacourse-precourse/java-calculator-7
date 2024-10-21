package calculator.controller;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class CalculatorController {

    public void run() {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine().trim();
            Calculator calculator = new Calculator();
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            CalculatorService service = new CalculatorService(calculator, exceptionHandler);

            service.getInputValues(input);
            service.validateInput();

            // 계산 결과 출력
            service.sumOfList();
            service.printResult();

    }

}
