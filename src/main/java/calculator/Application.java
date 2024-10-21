package calculator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new Calculator();
        ResultPrinter printer = new ResultPrinter();

        // 1. 입력받기 기능
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = getInput();

        // 2. 빈 문자열 처리
        int emptyCheck = calculator.handleEmptyInput(input);
        if (emptyCheck == 0) {
            printer.printResult(0);
            return;
        }

        // 3. 커스텀 구분자 처리
        List<String> delimiters = calculator.getDelimiters(input);

        // 4. 문자열에서 숫자 추출
        String[] numbers = calculator.extractNumbers(input, delimiters);

        // 5. 숫자의 합 계산
        int result = calculator.calculateSum(numbers);

        // 7. 결과 출력
        printer.printResult(result);

    }

    // 1. 입력받기 기능
    private static String getInput() {
        return readLine(); // 입력된 문자열 그대로 반환
    }
}
