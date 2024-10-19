package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public int caculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        // 커스텀 구분자
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }

        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }//calculate


    private int calculateSum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            number = number.trim(); // 양쪽 공백 제거
            total += validateNumber(number);
        }
        return total;
    }//calculateSum

    private int validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) { // 숫자가 음수라면
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
    }
}
