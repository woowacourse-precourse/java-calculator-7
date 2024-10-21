package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        result = calculateSum(input);
        System.out.println("결과 : " + result);
    }

    private static int calculateSum(String input) {
        // 빈 문자열 입력 시
        if (input.isEmpty()) {
            return 0;
        }

        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser(inputValidator);
        Calculator calculator = new Calculator();
        String[] parsedList;

        if (inputParser.isCustomDelimiterExisted(input)) {
            parsedList = inputParser.parseCustomDelimiterInput(input);
        } else {
            parsedList = inputParser.parseDefaultInput(input);
        }
        int[] numbers = calculator.toIntArray(parsedList);
        return calculator.add(numbers);
    }

}
