package calculator;

import static calculator.Calculator.handleInvalidInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 사용자 입력 문자열을 전처리하여 피연산자(숫자)를 추출하는 기능을 제공하는 클래스
 */
public class InputProcessor {

    private String delimiterRegex; // 구분자 정규표현식
    private List<String> tokens = new ArrayList<>(); // 구분자 기준으로 분리한 문자열 토큰

    /**
     * InputProcessor 클래스의 생성자 - delimiterRegex 필드 초기화
     */
    public InputProcessor() {
        this.delimiterRegex = "[,:]"; // 기본 구분자 설정
    }

    /**
     * 사용자 입력 문자열에서 숫자 추출
     */
    public List<Integer> extractDigits() {

        String operationInput = getOperationInput(); // 사용자 입력 전처리

        if (!isValidInput(operationInput, delimiterRegex)) { // 문자열 유효성 검증
            handleInvalidInput(operationInput);
        }

        List<Integer> digits = new ArrayList<>(List.of(0)); // 입력이 빈 문자열("")인 경우 0 반환
        if (!tokens.getFirst().isEmpty()) { // tokens가 비어 있지 않은 경우에만 처리
            digits.clear();
            try {
                digits = tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
            } catch (NumberFormatException | NullPointerException e) {
                handleInvalidInput(operationInput);
            }
        }

        return digits;
    }

    /**
     * 구분자에 따라 입력 문자열 전처리 - 커스텀 구분자이면 'n' 뒤의 문자열만 반환
     */
    private String getOperationInput() {
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
     * 주어진 문자열의 유효성 검증
     */
    private boolean isValidInput(String input, String regex) {
        tokens = Stream.of(input.split(regex)).map(String::trim).collect(Collectors.toList()); // 토큰 분리
        return tokens.stream().noneMatch(token -> token.matches(".*[^0-9].*"));
    }

    /**
     * 사용자 입력 받기
     */
    private String getUserInput() {
        return Console.readLine().trim();
    }
}
