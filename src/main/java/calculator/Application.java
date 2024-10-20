package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Calculator {
    private static final String GET_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String FINISH_MESSAGE = "결과 : ";

    private String input;
    private int result;

    Calculator(String input) {
        this.input = input;
        this.result = separatorLocator(input);
    }

    private static int defaultSeparator(String input){
        String[] separators = {",", ":"};
        return calculateNumber(input, Arrays.toString(separators));
    }

    private static int customSeparator(String input){
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String separator = matcher.group(1);
            String resultString = input.substring(matcher.end());

            return calculateNumber(resultString, separator);
        } else {
            return 0;
        }
    }

    private static int calculateNumber(String input, String separator) {
        int sum = 0;

        String [] numbers = input.split(separator);

        for (String number : numbers) {
            int value = Integer.parseInt(number.trim());

            sum += value;
        }

        return sum;
    }

    private static int separatorLocator(String input) {
        if(input.contains("//") && input.contains("\\n")){
            return customSeparator(input);
        }else {
            return defaultSeparator(input);
        }
    }
}
