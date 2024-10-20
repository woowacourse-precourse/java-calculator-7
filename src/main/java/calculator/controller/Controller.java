package calculator.controller;

import static calculator.view.View.displayInputPrompt;
import static calculator.view.View.displayResult;

import calculator.model.InputHandler;

public class Controller {
    InputHandler inputHandler = new InputHandler();

    public void start() {
        displayInputPrompt();
        inputHandler.setInputString(); // 문자열 받는 메서드
    }

    public void calculate() {
        inputHandler.ensureCustomDelimiter();// 커스텀 구분자가 있는 지 확인
        inputHandler.extractNumbers();
    }

    public void resulting() {
        inputHandler.getResult();
        displayResult(inputHandler);
    }
}
