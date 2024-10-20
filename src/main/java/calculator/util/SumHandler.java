package calculator.util;

import calculator.util.NegativeNumberHandler;

public class SumHandler {
    // 문자열을 숫자로 분리하고 합산하는 메서드
    public static int sumNumbers(String str, String delimiter) {
        String[] numbers = str.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (!number.trim().isEmpty()) { // 빈 문자열이 아닌 경우만 처리
                int num = Integer.parseInt(number.trim());
                NegativeNumberHandler.checkNegativeNumber(num); // 음수 체크
                sum += num; // 숫자 합산
            }
        }

        return sum;
    }
}
