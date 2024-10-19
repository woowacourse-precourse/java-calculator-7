package Delimiter;

import exception.ErrorMessage;

public class CustomDelimiter extends Delimiter {

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
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NUMBER.toString());
        }
        return numbers;
    }

    // 커스텀 구분자 + 기본 구분자로 추출한 숫자(type: String) 배열 반환
    // 여기서 예외처리 안 한 이유는 \n이 없는 경우는 getDelimiter 에서 걸러지기 때문
    private static String[] getToken(String input, String delimiterPattern) {
        String temp = input.substring(input.indexOf("\\n") + 2);
        return temp.split(delimiterPattern);
    }

    // 커스텀 구분자 추출 메서드
    private static String getDelimiter(String input) {
        try {
            String temp = input.substring(0, input.indexOf("\\n"));
            return temp.substring(2);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_GET_DELIMITER.toString());
        }
    }
}
