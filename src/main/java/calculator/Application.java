package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        List<Integer> numbers = validateAndExtractNumbers(input);
        int sum = calculateSum(numbers);
        printResult(sum);
    }

    // 문자열 입력 받기
    private static String getInput() {
        System.out.println(("덧셈할 문자열을 입력해 주세요."));
        return Console.readLine();
    }

    private static List<Integer> validateAndExtractNumbers(String input) {
        InputValidator validator = new InputValidator();

        // 빈 문자열 검증
        int result = validator.validateEmptyString(input);
        if (result == 0) {
            System.out.println("결과 : 0");
        }
        // 숫자 추출
        GetNumbers getNumbers = new GetNumbers();
        List<Integer> numbers = getNumbers.extractNumbers(input);

        // 음수값 검증
        validator.validateNegative(numbers);

        return numbers;
    }

    private static int calculateSum(List<Integer> numbers) {
        Calculator calculator = new Calculator();
        return calculator.sumNumbers(numbers);
    }

    private static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
