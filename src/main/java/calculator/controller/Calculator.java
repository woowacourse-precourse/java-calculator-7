package calculator.controller;

import static calculator.view.View.displayInputPrompt;
import static calculator.view.View.displayResult;

import calculator.domain.InputProcessor;

public class Calculator {
    InputProcessor inputProcessor = new InputProcessor();

    public void start() {
        displayInputPrompt();
        inputProcessor.setInputString();
    }

    public void process() {
        inputProcessor.processInputString();
    }

    public void display() {
        displayResult(inputProcessor);
    }
}
