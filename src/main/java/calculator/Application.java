package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    
    //구분자
    static final String DEFAULT_DELIMITER = "[,:]"; // 기본 구분자: 콤마(,) 및 콜론(:)
    static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"; // 커스텀 구분자
    
    //메시지
    static final String EMPTY_STRING_ERROR = "빈 문자열은 허용되지 않습니다."; // 빈 문자열 에러 메시지
    static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다: "; // 음수 에러 메시지
    static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해야 합니다: "; // 유효하지 않는 메시지

    // TODO: 프로그램 구현
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요."); //입력
        String input = Console.readLine();
        run(input); // 입력값 처리 및 결과 출력
    }

    // TODO: 입력된 문자열을 기반으로 덧셈 결과를 계산하는 메서드
    public static long calculate(String input) {
        Calculator calculator = new Calculator(); // Calculator 객체 생성
        return calculator.add(input); // 입력값을 사용하여 덧셈 결과 반환
    }

    // TODO: 입력 값을 처리하고 결과를 출력하는 메서드
    public static void run(String input) {
        try {
            long result = calculate(input); // 입력값을 기반으로 계산
            System.out.println("결과 : " + result); // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생 출력

        }
    }
}

class Calculator {
    // TODO: 입력값에 대한 덧셈을 처리하는 메서드
    public long add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 빈 문자열 또는 null일 경우 0 반환
        }

        // 입력값을 구분자에 따라 나누고 합산 처리
        String[] tokens = splitInput(input); // 구분자에 따라 입력값 분리
        return calculateSum(tokens); // 분리된 값을 기반으로 합계 계산
    }

    // TODO: 입력 문자열을 구분자에 따라 분리하는 메서드
    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(Application.CUSTOM_DELIMITER_PATTERN).matcher(input); //구분
        if (matcher.find()) {
            var customDelimiter = matcher.group(1); // 커스텀 구분자 추출
            var numbers = matcher.group(2); // 나머지 숫자 문자열 추출
            return numbers.split(Pattern.quote(customDelimiter)); // 커스텀 구분자로 분리하여 반환
        }
        return input.split(Application.DEFAULT_DELIMITER); // 기본 구분자로 분리하여 반환
    }

    // 숫자 합산 처리
    private long calculateSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToLong(this::parseNumber) // 각 토큰을 숫자로 변환
                .sum(); // 변환된 숫자들의 합계 계산
    }

    // TODO: 문자열을 숫자로 변환하는 메서드
    private long parseNumber(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException(Application.EMPTY_STRING_ERROR); // 빈 문자열 처리
        }

        try {
            long number = Long.parseLong(token); // Long 타입으로 변환
            if (number < 0) {
                throw new IllegalArgumentException(Application.NEGATIVE_NUMBER_ERROR + number); // 음수 처리
            }
            return number; // 유효한 숫자 반환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Application.INVALID_NUMBER_ERROR + token); // 유효하지 않은 숫자 처리
        }
    }
}
