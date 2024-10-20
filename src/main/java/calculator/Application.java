package calculator;

public class Application {
    public static final String CUSTOM_DELIMITER_FRONT = "//";
    public static final String CUSTOM_DELIMITER_BACK = "\\n";
    public static final String BASIC_DELIMITER = "[,:]";

    public static void main(String[] args) {

        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        Calculator calculator = new Calculator();

        int sum;

        String input = inputManager.inputStr();
        sum = calculator.processCalculate(input);
        outputManager.outputSum(sum);
    }
}
