package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 프로그램 시작 시 출력 메세지
        ConsoleView consoleView = new ConsoleView();
        consoleView.DisplayInput();

        String input = Console.readLine();

        DelimiterHandler delimiterHandler = new DelimiterHandler(input);

        // 입력값이 숫자 하나인 경우 (구분자가 없는 숫자)
        if (isSingleNumber(input)) {
            consoleView.DisplayResult(Integer.parseInt(input.trim()));  // 바로 출력
            return;
        }

        // 입력받은 문자열을 구분자로 나눠서 저장할 배열
        String[] words = delimiterHandler.splitInput();

        Calculator calculator = new Calculator();
        // 숫자의 합을 계산하는 로직
        int sum = calculator.CalculateSum(words);

        // 결과 출력
        consoleView.DisplayResult(sum);
    }

    // 단일 숫자인지 확인하는 메서드
    private static boolean isSingleNumber(String input) {
        return input.matches("^\\d+$");  // 숫자만 포함된 입력인지 확인
    }
}
