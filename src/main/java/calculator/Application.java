package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    static InputValidator validator = new InputValidator();
    static Parser parser = new Parser();

    public static void main(String[] args) {
        Application application = new Application();
        String input = application.getInputString();
        PatternType patternType = validator.validate(input);
        List<Integer> numbers = parser.parseToInt(input, patternType);
        application.printResult(1);
    }

    private String getInputString() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }

    private void printResult(int result) {
        System.out.print("결과 : " + result);
    }
}