package calculator;

public class StringCalculator {
    private int sum = 0;

    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final Validator validator;

    public StringCalculator() {
        this.inputManager = new InputManager();
        this.outputManager = new OutputManager();
        this.validator = new Validator();
    }

    private boolean isCustomInput(String str) {
        return str.contains(Constant.CUSTOM_DELIMITER_FRONT) && str.contains(Constant.CUSTOM_DELIMITER_BACK);
    }

    private boolean isDefaultInput(String str) {
        return str.contains(",") || str.contains(":");
    }

    private String parseCustomDelimiter(String str) {
        return str.substring(str.indexOf(Constant.CUSTOM_DELIMITER_FRONT) + 2,
                str.indexOf(Constant.CUSTOM_DELIMITER_BACK));
    }

    private String deleteCustomDelimiter(String str) {
        return str.substring(str.indexOf(Constant.CUSTOM_DELIMITER_BACK) + 2);
    }

    private String replaceCustomToBasic(String delimiter, String str) {
        return str.replace(delimiter, ",");
    }

    private int handleCustomInput(String str) {
        validator.checkCustomStyle(str);
        String custom = parseCustomDelimiter(str);
        validator.checkCustomEmpty(custom);
        String newInput = deleteCustomDelimiter(str);
        String replacedInput = replaceCustomToBasic(custom, newInput);

        return calculateSum(replacedInput);
    }

    private int calculateSum(String str) {
        String[] numbers = str.split(Constant.BASIC_DELIMITER);
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                validator.checkInputValid(number);
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    public void processCalculate() {

        String input = inputManager.inputStr();

        if (isCustomInput(input)) {
            sum = handleCustomInput(input);
        } else if (isDefaultInput(input)) {
            sum = calculateSum(input);
        } else if (input.isEmpty()) {
            sum = 0;
        } else if (input.matches("[0-9]+")) {
            sum = Integer.parseInt(input);
        } else {
            validator.checkCustomStyle(input);
        }

        outputManager.outputSum(sum);
    }
}
