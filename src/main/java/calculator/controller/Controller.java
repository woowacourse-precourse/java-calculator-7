package calculator.controller;

import calculator.model.InputHandler;
import calculator.view.View;

public class Controller {
    InputHandler inputHandler = new InputHandler();
    View view = new View();

    public void start() {
        view.displayInputPrompt();
        inputHandler.setInputString(); // 문자열 받는 메서드
    }

    public void calculate() {
        inputHandler.ensureCustomDelimiter();// 커스텀 구분자가 있는 지 확인
        inputHandler.extractNumbers();
    }

    public void resulting() {
        inputHandler.getResult();
        view.displayResult();
    }
}
