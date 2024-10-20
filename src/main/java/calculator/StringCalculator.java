package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public String[] splitInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        if (input.startsWith("//")) {
            int customIdx = input.indexOf("\n");
            if (customIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            String custom = input.substring(2, customIdx);
            String numberString = input.substring(customIdx + 1);
            return numberString.split(Pattern.quote(custom));
        }

        return input.split("[,:]");
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        int sum = 0;

        return sum;
    }

}