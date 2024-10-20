package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private final DigitExtractor digitExtractor;
    private final OperationProcessor operationProcessor;
    private String delimiterRegex; // 구분자 정규표현식

    public Calculator() {
        this.digitExtractor = new DigitExtractor();
        this.operationProcessor = new OperationProcessor();
        this.delimiterRegex = "[,:]";
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = getUserInput();
        if (input.startsWith("//")){ // 커스텀 구분자 사용
            char customDelimiter = extractCustomDelimiter(input);
            delimiterRegex = delimiterRegex + "|" + Pattern.quote(Character.toString(customDelimiter));
            input = getUserInput();
        }
        List<Integer> digits = digitExtractor.extractDigits(input, delimiterRegex);
        int result = operationProcessor.calculate(digits);
        System.out.println("결과 : " + result);
        Console.close();
    }

    /**
     * 사용자 입력 받기
     */
    public String getUserInput() {
        return Console.readLine().trim();
    }

    /**
     * 커스텀 구분자 추출
     */
    private char extractCustomDelimiter(String customInput) {
        if (customInput.length() > 3 || customInput.length() == 2 ||
                Character.getNumericValue(customInput.charAt(2)) != -1) {
            handleInvalidInput(customInput);
        }
        return customInput.charAt(2);
    }

    /**
     * 유효하지 않은 입력값 예외 처리
     */
    public static void handleInvalidInput(String input) {
        System.out.println("유효하지 않은 문자열 입니다. 프로그램을 종료합니다.");
        throw new IllegalArgumentException("Invalid input: " + input);
    }

}
