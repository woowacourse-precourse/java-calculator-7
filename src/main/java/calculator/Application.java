package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String defaultDelimiter = ",|:";
        String[] splitInputNumber;
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String inputDelimiter = matcher.group(1);
            input = matcher.replaceFirst("");
            String delimiter = defaultDelimiter + "|" + inputDelimiter;
            splitInputNumber = input.split(delimiter);
        } else {
            splitInputNumber = input.split(defaultDelimiter);
        }
        
        for (String number : splitInputNumber) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
        }

        int result = 0;
        for (String number : splitInputNumber) {
            result += Integer.parseInt(number);
        }

        System.out.println("결과 : " + result);
    }

}
