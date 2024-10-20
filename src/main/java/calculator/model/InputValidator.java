package calculator.model;

import java.util.regex.Pattern;

// 입력 검증 클래스
public class InputValidator {

    // 상수 정의 (기본 구분자, 커스텀 구분자, 개행 문자)
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE = "\\n";

    // 입력을 받아 검증하고 숫자 배열을 반환하는 메서드
    public String[] validate(String input) {
        if(input == null || input.isEmpty()) {
            return new String[] {"0"}; // 빈 입력일 경우 기본값 반환
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return validateCustomDelimiter(input); // 커스텀 구분자 처리
        } else {
            return validateDefaultDelimiter(input); // 기본 구분자(쉼표, 콜론) 처리
        }
    }

    // 기본 구분자(쉼표, 콜론)로 입력을 처리하는 메서드
    private String[] validateDefaultDelimiter(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER_REGEX);
        checkNegativeNumbers(numbers); // 음수 검증 수행
        return numbers;
    }

    // 커스텀 구분자 처리 및 검증하는 메서드
    private String[] validateCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf(NEWLINE);

        // 구분자 포맷이 잘못된 경우 예외 발생
        if (delimiterIndex == -1 ) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다. 커스텀 구분자는 //로 시작하고 \\n으로 끝나야 합니다.");
        }

        // "//"와 "\n" 사이 구분자 추출
        String delimiter = input.substring(2, delimiterIndex);

        // 구분자가 비어 있는지 확인
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있을 수 없습니다.");
        }

        // 구분자 이후 숫자 부분 추출
        String numbersPart = input.substring(delimiterIndex +2); // 구분자 이후 숫자 부분 추출

        if (numbersPart.isEmpty()) {
            throw new IllegalArgumentException("숫자 부분이 비어 있습니다.");
        }

        //커스텀 구분자로 숫자 분리
        String[] numbers = numbersPart.split(Pattern.quote(delimiter));
        checkNegativeNumbers(numbers); // 음수 확인
        return numbers;
    }

    // 음수 값을 검증하는 메서드
    private void checkNegativeNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.isEmpty()) { //빈 문자열 무시
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
                }
            }
        }
    }
}
