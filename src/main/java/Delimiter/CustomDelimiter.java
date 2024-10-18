package Delimiter;

public class CustomDelimiter {

    public static final String ERROR_INPUT_IS_NUMBER = "[ERROR] 구분자 외 입력은 오직 숫자만 가능합니다.";
    public static final String ERROR_INPUT_IS_POSITIVE = "[ERROR] 숫자는 양수만 입력 가능합니다.";
    public static final String ERROR_INPUT_IS_EMPTY = "[ERROR] 구분자 사이에 값을 입력해야 합니다.";

    public static int[] getNumber(String input) {
        String customDelimiter = getDelimiter(input);
        String delimiterPattern = ",|:|" + customDelimiter;

        String[] tokens = getToken(input, delimiterPattern);

        int[] numbers = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                checkIsEmpty(tokens[i]);
                numbers[i] = isPositive(Integer.parseInt(tokens[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NUMBER);
        }
        return numbers;
    }

    private static void checkIsEmpty(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_EMPTY);
        }
    }

    private static int isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_POSITIVE);
        }
        return number;
    }

    // 커스텀 구분자 + 기본 구분자로 추출한 숫자(type: String) 배열 반환
    private static String[] getToken(String input, String delimiterPattern) {
        String temp = input.substring(input.indexOf("\\n") + 2);
        return temp.split(delimiterPattern);
    }

    // 커스텀 구분자 추출 메서드
    private static String getDelimiter(String input) {
        String temp = input.substring(0, input.indexOf("\\n"));
        return temp.substring(2);
    }
}
