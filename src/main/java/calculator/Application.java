package calculator;

public class Application {
    public static final String CUSTOM_DELIMITER_FRONT = "//";
    public static final String CUSTOM_DELIMITER_BACK = "\\n";
    public static final String BASIC_DELIMITER = "[,:]";

    public static void main(String[] args) {

        int sum = 0;

        String input = InputManager.inputStr();

        if (Calculator.isCustomInput(input)) {
            sum = Calculator.handleCustomInput(input);
        } else if (Calculator.isBasicInput(input)) {
            sum = Calculator.calculateSum(input);
        } else if (input.isEmpty()) {
            sum = 0;
        } else if (input.matches("[0-9]+")) {
            sum = Integer.parseInt(input);
        } else {
            Validator.checkCustomStyle(input);
        }

        OutputManager.outputSum(sum);
    }
}
