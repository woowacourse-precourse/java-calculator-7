package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    //구분자
    private String delimiter;
    // 계산 수식
    private String expression;

    // 사용자 입력에서 피연산자를 추출
    public int[] extractOperands(String userInput) {
        if (userInput.isEmpty()) {
            return new int[]{0};
        }
        updateDelimiterAndExpression(userInput);
        return extractNumbersFromExpression(expression, delimiter);
    }

    //구분자와 수식을 업데이트
    private void updateDelimiterAndExpression(String userInput) {
        if (hasCustomDelimiterIn(userInput)) {
            expression = extractExpression(userInput);
            delimiter = "[.:" + extractDelimiter(userInput) + "]";
        } else {
            expression = userInput;
            delimiter = "[,:]";
        }
    }

    //수식을 추출하는 메서드
    public String extractExpression(String userInput) {
        return userInput.replaceAll("//.\\\\n", "");
    }

    //구분자를 추출하는 메서드
    public String extractDelimiter(String userInput) {
        Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(userInput);
        matcher.find(); //??????
        return matcher.group(1);
    }

    // 사용자 입력에 커스텀 구분자가 포함되어 있는지 확인
    public boolean hasCustomDelimiterIn(String userInput) {
        return userInput.matches("//.\\\\n.*");
    }

    // 수식에서 구분자를 기준으로 숫자를 추출하는 메서드
    private int[] extractNumbersFromExpression(String expression, String delimiter) {
        String[] inputStringNumbers = parseUserInput(expression, delimiter);
        return changeStringArrayToIntegerArray(inputStringNumbers);
    }

    private String[] parseUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }

    // 문자열 배열을 정수 배열로 변환하는 메서드
    private int[] changeStringArrayToIntegerArray(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(number -> {
                    int intValue = Integer.parseInt(number);
                    if (intValue < 0) {
                        throw new IllegalArgumentException("Negative numbers are not allowed: " + intValue);
                    }
                    return intValue;
                })
                .toArray();
    }
}
