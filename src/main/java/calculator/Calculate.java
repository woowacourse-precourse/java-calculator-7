package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculate {


    public int splitString(String input) {
        String customSeparator = "";
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            customSeparator = matcher.group(1);
        }
        input = input.replaceAll("//(.*?)\n", "");
        String numbers = input.replaceAll("[,:]", "");
        return addition(customSeparator, numbers);
    }

    private int addition(String customSeparator, String numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(isCustomSeparator(customSeparator, numbers.charAt(i))) {
                continue;
            }
            sum += isPositiveNumber(numbers.charAt(i));
        }
        return sum;
    }

    private boolean isCustomSeparator(String customSeparator, char num) {
        return num == customSeparator.charAt(0);
    }

    private int isPositiveNumber(char num) {
        if(Character.isDigit(num) && num - '0' > 0) {
            return num - '0';
        }
        throw new IllegalArgumentException();
    }
}
