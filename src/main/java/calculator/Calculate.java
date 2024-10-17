package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculate {


    public void splitString(String input) {
        String customSeparator = "";
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            customSeparator = matcher.group(1);
        }
        input = input.replaceAll("//(.*?)\n", "");
        String numbers = input.replaceAll("[,:]", "");
        addition(customSeparator, numbers);
    }

    private static int addition(String customSeparator, String numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(numbers.charAt(i) == customSeparator.charAt(0)) {
                continue;
            }
            sum += isPositiveNumber(numbers.charAt(i));
        }
        return sum;
    }

    private static int isPositiveNumber(char num) {
        if(Character.isDigit(num) && num - '0' > 0) {
            return num - '0';
        }
        throw new IllegalArgumentException();
    }
}
