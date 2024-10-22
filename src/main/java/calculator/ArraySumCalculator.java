package calculator;

import calculator.util.StringSplitter;

// 배열의 요소를 더하는 클래스
public class ArraySumCalculator implements ArrayCalculator {
    private final StringSplitter stringsplitter;

    // 의존성 주입
    public ArraySumCalculator(StringSplitter stringsplitter) {
        this.stringsplitter = stringsplitter;
    }

    // 배열의 각 요소를 더하는 메서드
    @Override
    public int sumArrayElements(String input) {
        String[] numbers = stringsplitter.splitString(input);

        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
        }
        return sum;
    }
}