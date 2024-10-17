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
        int sum = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(numbers.charAt(i) == customSeparator.charAt(0)) {
                continue;
            }
            if(Character.isDigit(numbers.charAt(i)) && numbers.charAt(i) - '0' > 0) {
                sum += numbers.charAt(i) - '0';
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(sum);
    }
}
