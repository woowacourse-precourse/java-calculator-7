package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int calculate(String input) {

        int sum = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";

        if(input.startsWith("//")){

            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(5);
            }
            else {
                throw new IllegalArgumentException("잘못된 입력입니다: " + input);
            }
        }
        String[] tokens = input.split(delimiter); //쉼표나 콜론을 구분자로 분리

        int number;

        for (String token : tokens) {

            try {
                number = Integer.parseInt(token.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }

        return sum;
    }
}
