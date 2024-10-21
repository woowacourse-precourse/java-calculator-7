package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        String input = Console.readLine();

        // Calculator의 add 메서드를 호출하여 결과를 계산
        int result = Calculator.add(input);

        // 결과 출력
        System.out.println("결과: " + result);
    }
}