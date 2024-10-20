package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String CUSTOM_DELIMITER_FRONT = "//";
    private static final String CUSTOM_DELIMITER_BACK = "\\n";
    private static final String BASIC_DELIMITER = "[,:]";

    private static void checkInputValid(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException("문자열에 음수 혹은 숫자가 아닌 것은 포함될 수 없습니다.");
            } else {
                if (Integer.parseInt(str) == 0) {
                    throw new IllegalArgumentException("문자열에 양수만 포함될 수 있습니다");
                }
            }
        }
    }

    private static void checkCustomStyle(String str) {
        if (!str.startsWith(CUSTOM_DELIMITER_FRONT)) {
            throw new IllegalArgumentException("커스텀 구분자의 입력 양식이 맞지 않습니다.");
        }
    }

    private static void checkCustomEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 빈 문자열이 될 수 없습니다");
        }
    }

    private static boolean isCustomInput(String str) {
        return str.contains(CUSTOM_DELIMITER_FRONT) && str.contains(CUSTOM_DELIMITER_BACK);
    }

    private static boolean isBasicInput(String str) {
        return str.contains(",") || str.contains(":");
    }

    private static String parseCustomDelimiter(String str) {
        return str.substring(str.indexOf(CUSTOM_DELIMITER_FRONT) + 2, str.indexOf(CUSTOM_DELIMITER_BACK));
    }

    private static String deleteCustomDelimiter(String str) {
        return str.substring(str.indexOf(CUSTOM_DELIMITER_BACK) + 2);
    }

    private static String replaceCustomToBasic(String delimiter, String str) {
        return str.replace(delimiter, ",");
    }

    private static int handleCustomInput(String str) {
        checkCustomStyle(str);
        String custom = parseCustomDelimiter(str);
        checkCustomEmpty(custom);
        String newInput = deleteCustomDelimiter(str);
        String replacedInput = replaceCustomToBasic(custom, newInput);

        return calculateSum(replacedInput);
    }

    private static int calculateSum(String str) {
        String[] numbers = str.split(BASIC_DELIMITER);
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                checkInputValid(number);
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        if (isCustomInput(input)) {
            sum = handleCustomInput(input);
        } else if (isBasicInput(input)) {
            sum = calculateSum(input);
        } else if (input.isEmpty()) {
            sum = 0;
        } else if (input.matches("[0-9]+")) {
            sum = Integer.parseInt(input);
        } else {
            checkCustomStyle(input);
        }

        System.out.println("결과 : " + sum);
    }
}
