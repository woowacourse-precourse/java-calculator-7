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

            if (input.contains("\n")) {
                delimiter = "["+input.substring(2, input.indexOf("n")-2)+"]";
                input = input.substring(input.indexOf("n")+1);
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
