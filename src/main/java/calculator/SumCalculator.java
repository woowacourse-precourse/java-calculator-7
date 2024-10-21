package calculator;

import java.util.Arrays;

public class SumCalculator {

    public int calculateSum(String input, String delimiter) {

        // 구분자를 기준으로 split
        String[] numbers = input.split(delimiter);

        int sum = 0;

//        System.out.println(Arrays.toString(numbers));

        for (String number : numbers) {
//            System.out.println("number:"+ number);

            // 숫자가 아닌 문자라면 예외처리
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
            }

            // 음수라면 예외처리
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }

            sum += parsedNumber;  // 문자열을 정수로 변환 후 더하기
        }

        return sum;
    }

    // 숫자인지 판단
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
