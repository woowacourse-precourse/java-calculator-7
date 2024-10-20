package calculator;

public class Calculator {

    public static boolean isCustomInput(String str) {
        return str.contains(Application.CUSTOM_DELIMITER_FRONT) && str.contains(Application.CUSTOM_DELIMITER_BACK);
    }

    public static boolean isBasicInput(String str) {
        return str.contains(",") || str.contains(":");
    }

    private static String parseCustomDelimiter(String str) {
        return str.substring(str.indexOf(Application.CUSTOM_DELIMITER_FRONT) + 2,
                str.indexOf(Application.CUSTOM_DELIMITER_BACK));
    }

    private static String deleteCustomDelimiter(String str) {
        return str.substring(str.indexOf(Application.CUSTOM_DELIMITER_BACK) + 2);
    }

    private static String replaceCustomToBasic(String delimiter, String str) {
        return str.replace(delimiter, ",");
    }

    public static int handleCustomInput(String str) {
        Validator.checkCustomStyle(str);
        String custom = parseCustomDelimiter(str);
        Validator.checkCustomEmpty(custom);
        String newInput = deleteCustomDelimiter(str);
        String replacedInput = replaceCustomToBasic(custom, newInput);

        return calculateSum(replacedInput);
    }

    public static int calculateSum(String str) {
        String[] numbers = str.split(Application.BASIC_DELIMITER);
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                Validator.checkInputValid(number);
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
