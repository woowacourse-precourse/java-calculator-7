package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add (String input) {
        if (input == null || input.isEmpty()){
            return 0;
        }

        String delimiter = "[,|:]";
        String num = input;

        if (input.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (m.find()) {
                delimiter = Pattern.quote(m.group(1));
                num = m.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
        }

        String[] tokens = num.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0){
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }
        return sum;
    }
}
