package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 1. 쉼표 또는 콜론을 구분자로 문자열을 전달받아 숫자를 분리
        String userInput = Console.readLine();
        String[] numbers = userInput.split("[,:]");
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number.trim());
        }

        System.out.println("결과: " + result);
    }
}
