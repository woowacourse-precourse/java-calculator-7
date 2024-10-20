package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static calculator.Calculator.handleInvalidInput;

public class InputProcessor {

    private String delimiterRegex; // 구분자 정규표현식

    public InputProcessor() {
        this.delimiterRegex = "[,:]";
    }

    /**
     * 구분자 맞춰서 연산 대상이 되는 문자열 결정
     * 기본 구분자이면 첫번째 입력값을 반환하고, 커스텀 구분자이면 추가로 입력 받은 두번째 문자열을 반환한다.
     */
    public String getOperationInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = getUserInput();
        if (input.startsWith("//")){ // 커스텀 구분자 사용
            char customDelimiter = extractCustomDelimiter(input);
            delimiterRegex = delimiterRegex + "|" + Pattern.quote(Character.toString(customDelimiter));
            input = getUserInput();
        }
        return input;
    }

    /**
     * 사용자 입력 받기
     */
    private String getUserInput() {
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
     * 구분자 정규표현식 반환
     */
    public String getDelimiterRegex() {
        return delimiterRegex;
    }
}
