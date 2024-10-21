package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        try {
            int sumResult = add(inputString);
            System.out.println("결과 : " + sumResult);
        } catch (IllegalArgumentException exception) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static int add(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        String defaultDelimiter = ",|:"; // 기본 구분자 쉼표(,)와 콜론(:)
        Matcher customDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);

        if (customDelimiterMatcher.find()) {
            defaultDelimiter = Pattern.quote(customDelimiterMatcher.group(1)); // 커스텀 구분자를 추출
            inputString = customDelimiterMatcher.group(2); // 구분자 이후의 문자열 추출
        }

        String[] numberTokens = inputString.split(defaultDelimiter);
        return calculateSum(numberTokens);
    }

    private static int calculateSum(String[] numberTokens) {
        int totalSum = 0;
        for (String numberToken : numberTokens) {
            int number = parsePositiveInt(numberToken); // 음수 및 숫자 형식 확인
            totalSum += number;
        }
        return totalSum;
    }

    private static int parsePositiveInt(String numberToken) {
        try {
            int number = Integer.parseInt(numberToken);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + numberToken);
            }
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식: " + numberToken);
        }
    }
}
