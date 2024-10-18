package calculator;

import calculator.CalculationManager.Validator;

public class InputValidator implements Validator {
    @Override
    // 메인 검증 함수
    public void validate(String input) {
        // 1. 입력이 숫자나 "//"로 시작하는지 검증
        if (!input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력은 숫자 또는 '//'로 시작해야 합니다.");
        }

        // 2. 기본 구분자 사용 여부와 커스텀 구분자 사용 여부로 나누어 처리
        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            validateCustomSeparator(input);
        } else {
            // 기본 구분자 처리
            validateBasicSeparator(input);
        }
    }

    // A. 기본 구분자 사용 시 검증 로직
    public static void validateBasicSeparator(String input) {
        validateCharAndNegativeNumber(input, ",|:");  // 음수 혹은 다른 문자 사용 검증
    }

    // B. 커스텀 구분자 사용 시 검증 로직
    public static void validateCustomSeparator(String input) {
        // 1. "//" 뒤에 하나의 문자 구분자가 오고 "\n"이 4번째 인덱스에 있는지 확인
        if (input.length() < 5 || input.charAt(3) != '\\' || input.charAt(4) != 'n') {
            throw new IllegalArgumentException("커스텀 구분자는 한 문자여야 하며, 형식은 '//(구분자)\\n'이어야 합니다.");
        }

        // 2. 커스텀 구분자 추출 및 숫자 부분 분리
        String customSeparator = input.substring(2, 3);  // "//" 뒤의 한 글자 구분자 추출
        String numbers = input.substring(5);  // \n 이후 숫자 부분 추출
        // 메타 문자 처리
        String escapedCustomCh = StringUtil.escapeMetaCharacters(customSeparator);

        validateCharAndNegativeNumber(numbers, escapedCustomCh);  // 음수 혹은 다른 문자 사용 검증
    }

    // 음수 및 다른 문자 사용 검증
    public static void validateCharAndNegativeNumber(String input, String separator) {
        // 마지막 문자가 구분자인지 확인
        if (input.endsWith(String.valueOf(separator)) || input.endsWith(",") || input.endsWith(":")) {
            throw new IllegalArgumentException("입력의 마지막에 구분자가 사용되었습니다.");
        }

        String[] splitString = input.split(String.valueOf(separator));

        for (String s : splitString) {
            try {
                int number = Integer.parseInt(s);  // 숫자로 변환 시도
                if (number < 0) {
                    throw new IllegalArgumentException("음수가 사용되었습니다.");
                }
            } catch (NumberFormatException e) {
                // 숫자가 아닌 문자가 포함된 경우 예외 발생
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되었습니다: " + s);
            }
        }
    }


}
