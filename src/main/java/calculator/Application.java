package calculator;

import camp.nextstep.edu.missionutils.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static int StringCalculator(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",;";

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
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
        // TODO: 프로그램 구현
    }
}
