package calculator;

import calculator.parser.ExpressionParser;
import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Calculator {

    private final Parser parser;

    public Calculator() {
        parser = new ExpressionParser();
    }

    public String input() {
        return Console.readLine();
    }

    //think: 스트림의 강력함을 사용하면 좋겠지만, 이렇게 쓰는 방식이 좋을지 모르겠다.
    public double sumOfString(String[] value) {
        return Arrays.stream(value)
                .map(v -> {
                    try {
                        return Double.parseDouble(v);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자만 입력해주세요."); //think: 람다식 안에서 예외를 던지는 방식이 맞을까?
                    }
                })
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private static void findDelimiter(Parser parser, String text) {
        parser.setDelimiters(text);
    }

    private static String[] split(Parser parser, String text) {
        return parser.split(text);
    }
}
