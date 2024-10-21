package calculator.service;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorService {

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers;
        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            int delimiterEndIndex = input.indexOf("\n");  // 개행 문자로 구분
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));  // 커스텀 구분자 추출
            numbers = input.substring(delimiterEndIndex + 1).split(delimiter);  // 구분자를 기준으로 숫자 추출
        } else {
            // 기본 구분자 처리 (쉼표, 콜론)
            numbers = input.split("[,:]");
        }

        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())  // 빈 문자열 필터링
                .mapToInt(this::parseNumber)  // 숫자 변환 후 합산
                .sum();
    }

    private int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number.trim());  // 공백 제거 후 숫자 파싱
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }
}
