package calculator.view;

import calculator.model.InputHandler;

public class View {
    InputHandler inputHandler = new InputHandler();

    public void displayInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void displayResult() {
        System.out.println("결과 : " + inputHandler.getResult());
    }
}
