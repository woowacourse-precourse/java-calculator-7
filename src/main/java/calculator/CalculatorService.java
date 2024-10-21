package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 처리
        }

        String delimiters = DEFAULT_DELIMITERS;
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n"); // \n을 문자열로 인식
            if (delimiterEndIndex > 0) {
                // 사용자 정의 구분자 추가
                String customDelimiter = input.substring(2, delimiterEndIndex).trim();


                // 기본 구분자에 사용자 정의 구분자 추가
                delimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);

                // 구분자 이후의 숫자 부분을 정확히 설정
                numbers = input.substring(delimiterEndIndex + 2).trim(); // +2은 줄바꿈 문자의 다음 인덱스

            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String[] tokens = numbers.split(delimiters);
        return sumNumbers(tokens);
    }

    private int sumNumbers(String[] tokens) {
        int sum = 0;
        List<String> invalidNumbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) { // 빈 문자열 무시
                try {
                    int number = Integer.parseInt(token.trim());
                    sum += checkPositiveNumber(number);
                } catch (NumberFormatException e) {
                    invalidNumbers.add(token); // 잘못된 숫자 목록에 추가
                }
            }
        }

        if (!invalidNumbers.isEmpty()) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다: " + String.join(", ", invalidNumbers));
        }
        return sum;
    }

    private int checkPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
        return number;
    }
}