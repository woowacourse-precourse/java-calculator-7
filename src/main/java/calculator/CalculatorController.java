package calculator;

import java.util.Set;

public class CalculatorController {
    private final CalculatorModel model;
    private final ConsoleView view;

    public CalculatorController(CalculatorModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        try {
            String input = view.getInput();
            Set<Character> delimiters;

            if (!input.startsWith("//")) {
                delimiters = DelimiterFactory.getBaseDelimiters();
                int result = model.add(input, delimiters);
                view.printResult(result);
                return;
            }

            int lastNewlineIndex = DelimiterFactory.findFirstIndexAfterDelimiters(input);
            delimiters = DelimiterFactory.createDelimiters(input);

            if (lastNewlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }

            String expression = input.substring(lastNewlineIndex);
            int result = model.add(expression, delimiters);
            view.printResult(result);

        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            throw e;
        }
    }
}
