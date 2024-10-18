package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        // 1) 문자열 입력 및 처리
        String input = Console.readLine();

        // 1.1) 입력 문자열이 비어있을 경우 0을 출력
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        }
    }
}
