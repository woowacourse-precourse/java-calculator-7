package calculator;

import java.util.Arrays;

public class SumCalculator {

    public int calculateSum(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;

//        System.out.println(Arrays.toString(numbers));

        for (String number : numbers) {
//            System.out.println("number:"+ number);

            if (!isNumeric(number)) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
            }

            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }

            sum += parsedNumber;  // 문자열을 정수로 변환 후 더하기
        }

        return sum;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
