package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 분리
        String input = Console.readLine();
        String[] inputNumbers = input.split(",|:");
        int sum = 0;

        for(String number : inputNumbers) {
            sum += Integer.parseInt(number);
        }

        System.out.println("결과 : " + sum);
    }
}
