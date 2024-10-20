package calculator;

import static calculator.StringConstants.ONLY_NUMBERS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Application {
    public static int subStringStartIndex = 0;
    public static String delimiters = StringConstants.COLON_DELIMITER + "|" + StringConstants.COMMA_DELIMITER;
    public static String aNewDelimiter = null;

    public static void main(String[] args) {
        String inputString = getInputString();
        setConditionValues(inputString);
        checkStringContainOtherChar(inputString.substring(subStringStartIndex));
        System.out.println("결과: " + getNumbersSum(inputString));
    }

    private static int getNumbersSum(String inputString) {
        int sum = 0;
        String token;
        StringTokenizer st = new StringTokenizer(inputString.substring(subStringStartIndex), delimiters);
        while (st.hasMoreTokens()) {
            if ((token = st.nextToken()).contains("-")) {
                throw new IllegalArgumentException("양수만 입력해야합니다.");
            }
            if (token.equals(" ")) {
                throw new IllegalArgumentException("공란이 아닌 유효한 양수만 입력해야합니다.");
            }
            try {
                sum += Integer.parseInt(token);
            } catch (Exception e) {
                throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
            }
        }
        return sum;
    }

    private static void setConditionValues(String inputString) {
        if (isContainNewDelimiter(inputString)) {
            subStringStartIndex = inputString.indexOf("\\n") + 2;
            delimiters += "|" + getNewDelimiter(inputString);
            delimiters = Pattern.quote(delimiters);
        }
    }

    private static void checkStringContainOtherChar(String inputString) {
        int beforeLength = inputString.length();
        if (inputString.charAt(0) == ',' || inputString.charAt(0) == ':'
                || (aNewDelimiter != null && inputString.charAt(0) == aNewDelimiter.charAt(0))) {
            throw new IllegalArgumentException("문자열 첫 입력값이 올바르지 않습니다.");
        }

        String str = inputString.replaceAll(",|:", "");
        if (aNewDelimiter != null) {
            str = str.replaceAll(aNewDelimiter, "");
        }

        int afterLength = str.length();
        if (beforeLength - afterLength >= beforeLength / 2) {
            throw new IllegalArgumentException("구분자가 연속 등장할 수 없습니다.");
        }
        if (!(inputString.isEmpty() || inputString == null)) {
            if (!str.matches(ONLY_NUMBERS)) {
                throw new IllegalArgumentException("구분자 외 문자가 포함되어 있습니다.");
            }
        }
    }

    private static boolean isContainNewDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            if (inputString.contains("\\n")) {
                if (inputString.substring(0, inputString.indexOf("\\n")).isEmpty()
                        || (inputString.indexOf("\\n") - inputString.indexOf("//")) != 3) {
                    throw new IllegalArgumentException("신규 구분자의 형식이 올바르지 않습니다.");
                }
                return true;
            }
            throw new IllegalArgumentException("신규 구분자 지정 문법에 맞지 않습니다.");
        }
        return false;
    }

    private static String getNewDelimiter(String inputString) {
        String newDelimiter;
        newDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
        aNewDelimiter = newDelimiter;
        if (newDelimiter.matches(ONLY_NUMBERS)) {
            throw new IllegalArgumentException("신규 구분자에 숫자를 포함할 수 없습니다.");
        }
        return newDelimiter;
    }

    private static String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            return input;
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력값이 입력되었습니다.");
        }
    }
}
