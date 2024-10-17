package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    public static String[] tokenization(String message) {
        String Separator = ",|:";
        String numbers = message;

        if (message.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(message);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }

            Separator = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }
        return numbers.split(Separator);
    }

    public static int[] convertToNumber(String[] tokens) {
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                numbers[i] = Integer.parseInt(tokens[i].trim());
                if (numbers[i] < 0) {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        return numbers;
    }


}
