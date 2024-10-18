package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CalculatorController {
	private CalculatorService calculatorService;
	private Calculator calculator;

	public void run() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String line = Console.readLine();
		calculatorService = new CalculatorService(line);
		List<Integer> numbers = calculatorService.getNumbers();
		calculator = new Calculator(numbers);
		System.out.println("결과 : " + calculator.getSum());
	}


}
