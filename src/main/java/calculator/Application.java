package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String userInput = Console.readLine();
            System.out.println("결과 : " + add(userInput));
        } catch (java.util.NoSuchElementException e) {
            System.out.println("결과 : 0");
        }
    }

    public static int add(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(userInput);
    }
}
