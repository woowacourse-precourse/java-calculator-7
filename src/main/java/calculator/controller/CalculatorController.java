package calculator.controller;

import calculator.exception.CalculatorException;
import calculator.service.CalculatorService;
import calculator.util.StringParser;
import calculator.util.StringValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private final StringParser parser;
    private final StringValidator validator;
    private final CalculatorService calculator;

    public CalculatorController() {
        this.parser = new StringParser();
        this.validator = new StringValidator();
        this.calculator = new CalculatorService();
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 입력 유효성 검사
            validator.validate(input);

            // 문자열 파싱
            List<String> numbers = parser.parse(input);

            // 파싱된 숫자 유효성 검사
            validator.validateNumbers(numbers);

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
