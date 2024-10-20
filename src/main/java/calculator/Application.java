package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 첫 번째 줄 입력
        if (input.startsWith("//")) {
            // 커스텀 구분자가 있는 경우 다음 줄 입력 받기
            String nextLine = Console.readLine(); // 두 번째 줄 입력
            input += "\n" + nextLine; // 두 번째 줄을 포함
        }

        try {
            int result = Calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
