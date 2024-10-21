package calculator;

public class ApplicationController {

    private final StringAddCalculator calculator;
    private final ConsoleView view;

    public ApplicationController() {
        this.calculator = new StringAddCalculator();
        this.view = new ConsoleView();
    }

    public void run() {
        view.displayInputPrompt();
        String input = view.getInput();

        try {
            int result = calculator.add(input);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}