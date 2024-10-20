package calculator;

public class InputParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static String customDelimiter;

    public int[] parse(String input, Validator validator) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            extractCustomDelimiter(input);
            input = removeCustomDelimiter(input);
            System.out.println("customDelimiter = " + customDelimiter);
            validator.validateCustomInput(input, customDelimiter);
        } else {
            validator.validateDefaultInput(input);
        }
        return parseInteger(input);
    }

    private String removeCustomDelimiter(String input) {
        return input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
    }

    private void extractCustomDelimiter(String input) {
        customDelimiter = input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }

    private int[] parseInteger(String input) {
        int[] numbers = new int[input.length()];
//        String middle = "|";
//        if (customDelimiter == "[!@#$%^&*()]") { // TODO 특수문자 종류 체크
//            middle = "|\\";
//        }
        String[] stringNumbers = input.split(DEFAULT_DELIMITERS + "|" + customDelimiter); // TODO escape \\ ?

        for (int i = 0; i < stringNumbers.length; i++) {
            if (stringNumbers[i].isEmpty()) {
                continue;
            }
            numbers[i] = Integer.parseInt(stringNumbers[i]); // TODO 숫자 아닐경우 예외 처리
        }
        return numbers;
    }

//    public static boolean isDelimiter(String input) { // TODO
//        return input.matches(DEFAULT_DELIMITERS + "|" + customDelimiter);
//    }
}
