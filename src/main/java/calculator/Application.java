package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("계산할 문자열을 입력하세요:");
        String userInput = Console.readLine();

        InputCleaner cleaner = new InputCleaner();
        String sanitizedInput = cleaner.sanitize(userInput);  // 입력 포맷팅 (줄바꿈 처리)

        DelimiterManager delimiterManager = new DelimiterManager();
        String delimiters = delimiterManager.getDelimiters(sanitizedInput);  // 구분자 설정
        String numberString = delimiterManager.getNumberSection(sanitizedInput);  // 숫자 부분 추출

        Calculator calculator = new Calculator();
        int result = calculator.calculate(numberString, delimiters);  // 합 계산

        System.out.println("결과 : " + result);  // 결과 출력
    }
}