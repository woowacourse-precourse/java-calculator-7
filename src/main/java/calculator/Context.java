package calculator;

import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.Console;

/**
 * NOTE: Context 클래스를 만든 이유
 * Paser는 Paser에게 맞는 기능 split(), setDelimiter()이 있다.
 * Calculator는 Calculator에게 맞는 기능 execute()가 있다.
 * <p>
 * Calculator 내부에 private 메소드로 findDelimiter()를 선언하면 구분자를 찾는 책임이 Calculator에게 부여되므로
 * 책임 분리가 안된다고 생각했다.
 * <p>
 * 따라서 Context 라는 클래스를 만들어서, 이 클래스 안에서 Calculator와 Parser를 사용해 로직을 수행한다.
 */

// TODO: String -> StringBuiler 변경하기
public class Context {

    private final Parser parser;
    private final Calculator calculator;

    public Context(Parser parser, Calculator calculator) {
        this.parser = parser;
        this.calculator = calculator;
    }

    public void start() {
        String text = input();
        findDelimiter(text);
        String[] splited = split(text);
        calculate(splited);
    }

    private void calculate(String[] values) {
        System.out.println(String.format("결과 : " + calculator.sumOfString(values)));
    }

    private String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private void findDelimiter(String text) {
        parser.setDelimiters(text);
    }

    private String[] split(String text) {
        return parser.split(text);
    }
}
