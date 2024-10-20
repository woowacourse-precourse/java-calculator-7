package calculator.controller;

import calculator.model.InputHandler;
import calculator.view.View;

public class Controller {
    public void start() {
        InputHandler inputHandler = new InputHandler();
        View view = new View();

        view.displayInputPrompt();
        inputHandler.setInputString(); // 문자열 받는 메서드

        inputHandler.ensureCustomDelimiter();// 커스텀 구분자가 있는 지 확인
        inputHandler.extractNumbers();
        inputHandler.getResult();
        view.displayResult();
    }
}
