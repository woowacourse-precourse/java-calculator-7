package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;

public class IOService {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public void printResult(BigDecimal result) {
        System.out.println("결과: " + result.toPlainString());
    }
}