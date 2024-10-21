package calculator;

import calculator.parser.ExpressionParser;
import calculator.parser.NumberParser;

/**
 * think: 이 애플리케이션에 필요한 것
 * 1. Parser : 입력한 문자열 파싱
 * 2.Calculator : 파싱된 문자열 계산
 * 3. Application Context
 */
public class Application {
    public static void main(String[] args) {

        NumberParser parser = new ExpressionParser();
        Calculator calculator = new Calculator();

        Context context = new Context(parser, calculator);
        context.start();

    }
}
