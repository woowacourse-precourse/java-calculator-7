package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println("결과 : " + add(input));
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 이후 단계에서 추가 코드 작성
        return 0;
    }
}
