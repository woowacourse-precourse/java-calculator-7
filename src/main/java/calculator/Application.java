package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        String input;

        System.out.println("덧셈할 문자열을 입력해주세요.");
        input = Console.readLine();
        String[] numbers = input.split("[,:]");

        int sum = 0;
        for(String number : numbers) {
            if (!number.trim().isEmpty()) {
                try {
                    sum += Integer.parseInt(number.trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
        System.out.println("결과: " + sum);
    }
}
