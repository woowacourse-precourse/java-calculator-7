package calculator.controller;

import calculator.exception.CalculatorException;
import calculator.service.CalculatorService;
import calculator.service.ParsingService;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private final ParsingService parser;
    private final CalculatorService calculator;

    public CalculatorController() {
        this.parser = new ParsingService();
        this.calculator = new CalculatorService();
    }

    public void run() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 문자열 파싱
            List<String> numbers = parser.parse(input);

            // 덧셈 결과 계산
            String result = calculator.add(numbers);

            // 결과 출력
            System.out.println("결과 : " + result);
        } catch (CalculatorException e) {
            // 예외 발생 시 메시지 출력
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
