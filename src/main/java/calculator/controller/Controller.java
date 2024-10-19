package calculator.controller;

import calculator.model.Model;
import calculator.view.View;

public class Controller {

    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        try {
            String input = view.Input();
            int result = model.add(input);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}
