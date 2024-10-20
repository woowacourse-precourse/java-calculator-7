package calculator.controller;

import static calculator.view.View.displayInputPrompt;
import static calculator.view.View.displayResult;

import calculator.domain.InputProcessor;

public class Calculator {
    InputProcessor inputHandler = new InputProcessor();

    public void start() {
        displayInputPrompt();
        inputHandler.setInputString();
    }

    public void process() {
        inputHandler.processInputString();
    }

    public void display() {
        displayResult(inputHandler);
    }
}
