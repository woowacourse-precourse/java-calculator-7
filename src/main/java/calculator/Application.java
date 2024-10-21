package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {

    public static final String DELIMITER_INITIATOR = "//";
    public static final String DELIMITER_FINALIZER = "\\n";

    public static final String MESSAGE_NORMAL_REQUEST = "덧셈할 문자열을 입력해 주세요.";
    public static final String MESSAGE_NORMAL_RESULT = "결과";
    public static final String MESSAGE_ERROR_PREFIX = "[ERROR] ";
    public static final String MESSAGE_ERROR_NUMBER_AS_DELIMITER = MESSAGE_ERROR_PREFIX + "숫자를 구분자로 사용할 수 없습니다.";
    public static final String MESSAGE_ERROR_ILLEGAL_FORMULA = MESSAGE_ERROR_PREFIX + "소수(-)나 음수가 아닌, 정수와 구분자를 입력하세요.";
    public static final String MESSAGE_ERROR_NEGATIVE_NUMBER = MESSAGE_ERROR_PREFIX + "음수가 아닌 정수만 입력하세요.";
    public static final String MESSAGE_ERROR_PROBLEMATIC_INPUT = " 문제가 된 입력: ";

    public static void main(String[] args) {
        System.out.println(MESSAGE_NORMAL_REQUEST);
        String userInput = Console.readLine();

        String delimiterRegex = ",|:";

        if (userInput.startsWith(DELIMITER_INITIATOR)) {
            String userDelimiterInput = "";

            // delimiter(s) given with Enter key
            if (!userInput.contains(DELIMITER_FINALIZER)) {
                userDelimiterInput = userInput.substring(DELIMITER_INITIATOR.length());
                userInput = Console.readLine();
            }

            // delimiter(s) given with literal '\n'
            if (userInput.contains(DELIMITER_FINALIZER)) {
                userDelimiterInput = userInput.substring(DELIMITER_INITIATOR.length(),
                        userInput.indexOf(DELIMITER_FINALIZER));
                userInput = userInput.substring(userInput.indexOf(DELIMITER_FINALIZER) + DELIMITER_FINALIZER.length());
            }

            for (char delimiter : userDelimiterInput.toCharArray()) {
                // banned delimiters
                if (delimiter >= '0' && delimiter <= '9') {
                    throw new IllegalArgumentException(MESSAGE_ERROR_NUMBER_AS_DELIMITER + getProblematicInputMessage(
                            Character.toString(delimiter)));
                }
                delimiterRegex += "|" + Pattern.quote(Character.toString(delimiter));
            }
        }

        System.out.println(MESSAGE_NORMAL_RESULT + " : " + getSumResult(userInput, delimiterRegex));
    }

    private static long getSumResult(String userInput, String delimiterRegex) {
        long sumResult = 0;

        for (String numberToken : userInput.split(delimiterRegex)) {
            if (numberToken.isEmpty()) {
                continue;
            }

            long parsedNumber;
            try {
                parsedNumber = Long.parseLong(numberToken);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        MESSAGE_ERROR_ILLEGAL_FORMULA + getProblematicInputMessage(numberToken));
            }
            if (parsedNumber < 0) {
                throw new IllegalArgumentException(
                        MESSAGE_ERROR_NEGATIVE_NUMBER + getProblematicInputMessage(numberToken));
            }
            sumResult += parsedNumber;
        }
        return sumResult;
    }

    private static String getProblematicInputMessage(String problematicInput) {
        return MESSAGE_ERROR_PROBLEMATIC_INPUT + "\"" + problematicInput + "\"";
    }
}
