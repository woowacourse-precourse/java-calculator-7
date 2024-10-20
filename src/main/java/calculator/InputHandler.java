package calculator;

public class InputHandler {
    private final InputString input;

    public InputHandler(String input) {
        this.input = new InputString(input);
    }

    public void process() {
        if (input.isEmpty()) {
            ResultPrinter.print(0);
            return;
        }

        SeparatorManager separatorManager = new SeparatorManager();
        separatorManager.processInput(input.getRawInput());
        NumberManager numberManager = new NumberManager(separatorManager);
        numberManager.calculate(separatorManager.getNumberString());
    }
}
