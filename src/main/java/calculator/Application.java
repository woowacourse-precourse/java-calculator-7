package calculator;

import camp.nextstep.edu.missionutils.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static int stringCalculator(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("Invalid input format");
            }
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for(String token : tokens) {
            try {
                sum += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format");
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.printf("결과: %d\n", stringCalculator(input));
    }
}
