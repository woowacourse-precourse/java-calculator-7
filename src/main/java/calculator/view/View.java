package calculator.view;

import calculator.domain.InputProcessor;

public class View {

    public static void displayInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void displayResult(InputProcessor inputHandler) {
        System.out.println("결과 : " + inputHandler.getResult());
    }
}
