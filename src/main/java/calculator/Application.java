package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        double result = Calculator.add(input);
        if (result == (int) result) {  // 소수점 이하가 0인지 확인
            int intResult = (int) result;  // 변환
            System.out.println("결과 : " + intResult);
        } else {
            System.out.println("결과 : " + result);
        }
    }
}
