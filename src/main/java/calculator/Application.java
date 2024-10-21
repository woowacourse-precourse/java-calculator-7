package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        InputParser inputParser = new InputParser(input);
        InputValidator.validate(inputParser.getNumbersSection(), inputParser.getDelimiters());

        int sumResult = Calculator.sumNumbers(inputParser.extractNums());
        System.out.println("결과 : " + sumResult);
    }
}
