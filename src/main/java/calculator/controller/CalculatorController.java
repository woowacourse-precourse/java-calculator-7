package calculator.controller;

import calculator.domain.CustomDelimiter;
import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final CustomDelimiter customDelimiter;

    public CalculatorController() {
        this.customDelimiter = new CustomDelimiter();
    }

    public void run() {
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 빈 문자열이거나 null인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }

    }
}
