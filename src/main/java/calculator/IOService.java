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

    // 입력된 숫자와 구분자의 유효성을 검사하는 메서드
    private void validateInput(String input) {
        // 입력의 첫 번째와 마지막 문자가 숫자가 아닌 경우 예외 처리
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public void printResult(BigDecimal result) {
        System.out.println("결과: " + result);
    }
}