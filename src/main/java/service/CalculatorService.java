package service;

import java.util.Arrays;

public class CalculatorService {

    public int delimiterProcess(String input) {
        String defaultDelimiter = ",|:";  // 기본 구분자 (콤마와 콜론)
        String customDelimiter = "";  // 커스텀 구분자 초기화

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");  // 첫 번째 줄과 두 번째 줄 분리
            if (newlineIndex != -1) {
                customDelimiter = input.substring(2, newlineIndex).trim();  // 커스텀 구분자 가져오기
                input = input.substring(newlineIndex + 1);  // 숫자 입력 부분만 남김
                if (!customDelimiter.isEmpty()) {
                    defaultDelimiter += "|" + customDelimiter;  // 기본 구분자에 커스텀 구분자 추가
                }
            } else {
                throw new IllegalArgumentException("올바른 커스텀 구분자를 입력하세요.");
            }
        }

        // 입력 문자열을 구분자로 나누고 합산
        String[] numbers = input.split(defaultDelimiter);

        // 숫자 배열을 정수로 변환하고 합산
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
