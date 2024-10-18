package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력하세요:");
        int result = calculator.calculate();
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {

    public int calculate() {
        String input = Console.readLine(); // 사용자 입력 받기

        // null 혹은 빈 문자열을 입력할 경우 0을 반환
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 숫자 하나만 입력되었을 경우 해당 숫자를 반환
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
            return Integer.parseInt(input);
        }

        // 기본 동작 추가 예정
        return -1;  // 임시값
    }
}