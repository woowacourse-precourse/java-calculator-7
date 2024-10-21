package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public static List<Integer> getNumberList(String expression, List<String> delimiters) {
        List<Integer> numberList = new ArrayList<>();
        validateExpression(expression, delimiters);
        extractNumbers(expression, numberList);
        return numberList;
    }

    private static void validateExpression(String expression, List<String> delimiters) {
        for (char ch : expression.toCharArray()) {
            String character = String.valueOf(ch);
            if (!Character.isDigit(ch) && !delimiters.contains(character) && ch != ':' && ch != ',') {
                throw new IllegalArgumentException("\""+ character + "\" 는 유효한 구분자가 아닙니다." );
            }
        }
    }

    private static void extractNumbers(String expression, List<Integer> numberList) {
        Matcher matcher = NUMBER_PATTERN.matcher(expression);

        while (matcher.find()) {
            numberList.add(Integer.parseInt(matcher.group()));
        }
    }
}
