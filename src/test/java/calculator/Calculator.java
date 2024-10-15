package calculator;

import java.util.regex.Pattern;

public class Calculator {
    int add (String str) {
        if(str == "") return 0;

        if(str.contains("-") || str.contains("0")){
            throw new IllegalArgumentException("음수 또는 0이 입력되었습니다.");
        }

        String delimiter = ",|:";
        if(str.startsWith("//")){
            String customDelimiter = str.substring(2, str.indexOf("\n"));
            delimiter += "|" + Pattern.quote(customDelimiter);
            str = str.substring(str.indexOf("\n") + 1);
        }

        String[] split = str.split(delimiter);
        int sum = 0;
        for (String number : split) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
