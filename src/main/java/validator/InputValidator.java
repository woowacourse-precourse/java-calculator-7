package validator;


public class InputValidator {
    public static void validateInput(String input) {
        // 1. 빈 문자열은 허용
        if (input.isEmpty()) return;

        // 2. 음수 검사를 먼저 수행
        checkForNegativeNumbers(input);

        // 3. 커스텀 구분자 처리
        if (input.startsWith("//")) {
            validateCustomDelimiter(input);
        } else {
            // 4. 기본 구분자로 숫자 분리
            validateDefaultDelimiters(input);
        }
    }

    // 음수 검사
    private static void checkForNegativeNumbers(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    // 커스텀 구분자 유효성 검사
    private static void validateCustomDelimiter(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자는 //와 \\n 사이에 있어야 합니다.");
        }

        String[] parts = input.split("\\\\n", 2);
        if (parts.length < 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식입니다. \\n 이후에 숫자가 있어야 합니다.");
        }

        // 커스텀 구분자를 정규식에서 사용하기 위해 이스케이프 처리
        String customDelimiter = escapeSpecialCharacters(parts[0].substring(2)); // "//" 이후의 구분자 추출
        String numbersPart = parts[1];

        validateNumbers(numbersPart.split(customDelimiter));
    }

    // 기본 구분자로 유효성 검사
    private static void validateDefaultDelimiters(String input) {
        validateNumbers(input.split("[,:]"));
    }

    // 숫자 유효성 검사
    private static void validateNumbers(String[] tokens) {
        for (String token : tokens) {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다: " + token);
            }
        }
    }

    // 특수 문자를 정규식에서 사용할 수 있도록 이스케이프 처리하는 메서드
    private static String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1"); // 특수 문자를 정규식에서 이스케이프 처리
    }

    // 숫자 여부 확인
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}