package calculator.model;

import java.util.List;

// 문자열 배열의 숫자를 합산하는 계산기
public class StringCalculator {

    // List로 전달된 숫자들을 합산하는 메소드
    public int sumNumbers(List<String> numbers) {
        return calculateSum(numbers);
    }

    // Stream을 사용하여 List의 숫자들을 합산하는 메소드
    private int calculateSum(List<String> numbers) {
        return numbers.stream()
                .map(String::trim)  // 문자열 앞뒤 공백 제거
                .mapToInt(Integer::parseInt)  // 숫자로 변환
                .sum();  // 합산
    }

}