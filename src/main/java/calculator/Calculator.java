package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Calculator {

    static final String DEFAULT_DELIMITERS = "[,:]"; //정규식 표현
    static final String CUSTOM_DELIMITER_PREFIX = "//"; //커스텀 구분자를 구별해주는 앞부분
    static final String CUSTOM_DELIMITER_POSTFIX = "\\n"; //커스텀 구분자를 구별해주는 뒷부분
    static String customDelimiter;

    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static String[] extractNumber(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            if (delimiterIndex == -1) {
                // 만약 //는 들어왔는데 뒤에 나오는 문자열이 \n이 아니라 다른 문자열이 온다면 indexof는 -1을 반환함
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            String customTempDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
            String number = input.substring(CUSTOM_DELIMITER_PREFIX.length() + customTempDelimiter.length()
                    + CUSTOM_DELIMITER_POSTFIX.length());
            customDelimiter = Pattern.quote(customTempDelimiter) + "|" + DEFAULT_DELIMITERS;
            // 커스텀 구분자로만 이루어진 입력 체크
            if (number.matches(Pattern.quote(customTempDelimiter) + "+")) {
                throw new IllegalArgumentException("커스텀 구분자로만 이루어진 입력은 허용되지 않습니다.");
            }
            // 구분자로 끝나거나 시작하는 경우 체크
            if (number.matches(
                    ".*" + Pattern.quote(customTempDelimiter) + "$|^"
                            + Pattern.quote(customTempDelimiter) + ".*")) {
                throw new IllegalArgumentException("입력되지 않은 수가 있습니다.");
            }
            return number.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    public static int sum(String[] str) {
        int result = 0;
        for (String s : str) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static int preExceptionHandler(String input) {
        if (input.matches("[,:]+")) {
            throw new IllegalArgumentException("구분자로만 이루어진 입력은 허용되지 않습니다.");
        }
        if (input.matches(".*[,:]$|^[,:].*")) {  // 구분자로 끝나거나 시작하는 경우 체크
            throw new IllegalArgumentException("입력되지 않은 수가 있습니다.");
        }
        return 1;
    }

    public static int postExceptionHandler(String[] input) {
        for (String str : input) {
            try {
                int number = Integer.parseInt(str);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다 : " + number);
                }
            } catch (NumberFormatException e) { // 구분자에 의해 분리시킨 값이 숫자가 아닐경우
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다 : " + str);
            }
        }
        return 1;
    }

    public static int run() {
        String input;
        try {
            input = inputString();
        } catch (NoSuchElementException e) {
            return 0;
        }
        if (preExceptionHandler(input) == 0) {
            return 0;
        }
        String[] str = extractNumber(input);
        postExceptionHandler(str);
        return sum(str);
    }
}
