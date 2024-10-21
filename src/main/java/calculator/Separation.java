package calculator;

import java.util.regex.Pattern;

public class Separation {
    // Todo: 문자열에서 숫자 추출
    public static String[] separate(String input) {
        if (input.isEmpty()) {
            return new String[0];
        }
        String[] num;

        if (input.startsWith("//")) {
            int nextIndex = input.indexOf("\\n");
            String delimiter = input.substring(2, nextIndex);
            String numIndex = input.substring(nextIndex + 2);
            num = numIndex.split(Pattern.quote(delimiter));
            Validation.CheckNegativeNumbers(num);
            return num;

        }
        num = input.split("[,:]");
        Validation.CheckNegativeNumbers(num);
        return num;
    }

}
