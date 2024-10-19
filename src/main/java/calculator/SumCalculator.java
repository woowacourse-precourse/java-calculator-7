package calculator;

public class SumCalculator {

    // 구분자를 기준으로 숫자 분리 및 합산
    public int calculateTotal(String input, String delimiters) {
        String[] numberArray = input.split(delimiters);  // 구분자 기준으로 문자열 나누기

        int totalSum = 0;

        for (String numberPart : numberArray) {
            totalSum += parseAndValidateNumber(numberPart);  // 숫자 처리 및 합산
        }

        return totalSum;
    }

    // 숫자를 변환하고 음수 처리
    private int parseAndValidateNumber(String numberPart) {
        if (numberPart.isEmpty()) {
            return 0;  // 빈 값은 0으로 처리
        }

        int parsedNumber = Integer.parseInt(numberPart);  // 문자열을 숫자로 변환

        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }

        return parsedNumber;
    }
}