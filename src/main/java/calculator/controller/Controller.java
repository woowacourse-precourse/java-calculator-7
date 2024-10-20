package calculator.controller;

import static calculator.view.View.displayInputPrompt;
import static calculator.view.View.displayResult;

import calculator.domain.InputHandler;

public class Controller {
    InputHandler inputHandler = new InputHandler();

    public void start() {
        displayInputPrompt();
        inputHandler.setInputString(); // 문자열 받는 메서드
    }

    public void process() {
        inputHandler.processInputString();
    }

    public void display() {
        displayResult(inputHandler);
    }
}
