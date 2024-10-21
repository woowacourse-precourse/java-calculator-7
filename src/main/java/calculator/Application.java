package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        try {
            input = Console.readLine();
        } catch (java.util.NoSuchElementException e) {
            // 빈 문자열을 직접 입력받는 경우
            System.out.println("결과 : 0");
            return;
        }
        InputHandler inputHandler = new InputHandler();

        int result = inputHandler.processInput(input);
        System.out.println("결과 : " + result);

    }
}