package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요:");
        String input = Console.readLine(); //사용자입력
        try {
            int result = calculateSum(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
