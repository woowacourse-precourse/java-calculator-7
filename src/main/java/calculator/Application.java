package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine(); // 사용자 입력 받기

        try {
            int result = calculateSum(input); // 숫자 합산 수행
            System.out.println("결과 : " + result); // 결과 출력
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
