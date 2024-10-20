package calculator;

public class Calculator {
    private final Validator validator;

    public Calculator() {
        this.validator = new Validator();
    }

    private int sum = 0;

    private boolean isCustomInput(String str) {
        return str.contains(Application.CUSTOM_DELIMITER_FRONT) && str.contains(Application.CUSTOM_DELIMITER_BACK);
    }

    private boolean isBasicInput(String str) {
        return str.contains(",") || str.contains(":");
    }

    private String parseCustomDelimiter(String str) {
        return str.substring(str.indexOf(Application.CUSTOM_DELIMITER_FRONT) + 2,
                str.indexOf(Application.CUSTOM_DELIMITER_BACK));
    }

    private String deleteCustomDelimiter(String str) {
        return str.substring(str.indexOf(Application.CUSTOM_DELIMITER_BACK) + 2);
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
        String[] numbers = str.split(Application.BASIC_DELIMITER);
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                validator.checkInputValid(number);
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    public int processCalculate(String str) {
        if (isCustomInput(str)) {
            sum = handleCustomInput(str);
        } else if (isBasicInput(str)) {
            sum = calculateSum(str);
        } else if (str.isEmpty()) {
            sum = 0;
        } else if (str.matches("[0-9]+")) {
            sum = Integer.parseInt(str);
        } else {
            validator.checkCustomStyle(str);
        }
        return sum;
    }
}
