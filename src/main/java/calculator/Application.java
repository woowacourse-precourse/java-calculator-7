package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("계산할 문자열을 입력하세요:");

        String result = processUserInput(Console.readLine());
        System.out.println("결과 : " + result);
    }

    private static String processUserInput(String userInput) {
        InputCleaner cleaner = new InputCleaner();
        String sanitizedInput = cleaner.sanitize(userInput);  // 입력 포맷팅

        DelimiterManager delimiterManager = new DelimiterManager();
        String delimiters = delimiterManager.determineDelimiters(sanitizedInput);  // 구분자 설정
        String numberString = delimiterManager.extractNumberSection(sanitizedInput);  // 숫자 부분 추출

        SumCalculator calculator = new SumCalculator();
        int result = calculator.calculateTotal(numberString, delimiters);  // 합 계산

        return String.valueOf(result);
    }
}