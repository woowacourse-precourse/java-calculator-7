package calculator;

import java.math.BigInteger;

public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }
    
    public void run() {
        String input = view.getInput();

        if (input == null) {
            view.displayResult(BigInteger.ZERO);
            return;
        }

        boolean extendedMode = false;
        if (input.length() >= 5 && input.charAt(0) == '/' && input.charAt(1) == '/' &&
                input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            extendedMode = true;
        }

        try {
            BigInteger result = model.processInput(input, extendedMode);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}