package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 2. 기본 구분자로 문자열 분리, 결과 합산
        String[] numbers = input.split("[,:]");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

    }
}