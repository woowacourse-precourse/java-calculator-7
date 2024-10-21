package calculator;

import static calculator.Calculator.handleInvalidInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 전처리하고, 구분자를 추출하는 기능을 제공하는 클래스
 */
public class InputProcessor {

    private String delimiterRegex; // 구분자 정규표현식

    /**
     * InputProcessor 클래스의 생성자 - delimiterRegex 필드 초기화
     */
    public InputProcessor() {
        this.delimiterRegex = "[,:]"; // 기본 구분자 설정
    }

    /**
     * 구분자에 따라 입력받은 문자열 전처리 - 커스텀 구분자이면 'n' 뒤의 문자열만 반환
     */
    public String getOperationInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = getUserInput();
        if (input.startsWith("//")) { // 커스텀 구분자 사용
            char customDelimiter = extractCustomDelimiter(input);
            delimiterRegex = delimiterRegex + "|" + Pattern.quote(Character.toString(customDelimiter));
            input = input.substring(input.indexOf('n') + 1);
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
        if (Character.getNumericValue(customInput.charAt(2)) != -1 ||
                !(customInput.charAt(3) == '\\' && customInput.charAt(4) == 'n')) {
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
