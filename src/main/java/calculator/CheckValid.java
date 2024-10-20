package calculator;

public class CheckValid {

    // 숫자의 유효성을 확인하는 메서드
    static void isValidNum(String word) {
        // 숫자가 아닌 경우 예외 처리
        try {
            int num = Integer.parseInt(word);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
    }

    // 문자열에 공백이 포함되어 있는지 확인하는 메서드
    static void isValidString(String word) {
        if (word == null || word.isEmpty()) {
            return;  // 빈 문자열은 허용
        }

        // 숫자 또는 구분자 앞뒤에 공백이 있으면 예외 발생
        if (word.startsWith(" ") || word.endsWith(" ")) {
            throw new IllegalArgumentException("숫자나 구분자 앞뒤에 공백이 포함되어 있습니다.");
        }
    }

    // 구분자가 연속으로 있는지 확인하는 메서드
    static void checkContinuousDelimiters(String[] input) {
        // 각 구분자 사이에 비어있는 문자열이 있으면 구분자가 연속으로 사용된 것
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i].isEmpty()) {
                throw new IllegalArgumentException("구분자가 두 개 이상 연속으로 사용되었습니다.");
            }
        }
    }

    // 구분자 형식 검사를 위한 메서드
    static void checkDelimiterFormat(String input, int delimiterEnd) {
        // 구분자 형식이 올바른지 검사
        if (delimiterEnd == -1 || delimiterEnd == 2 || input.charAt(2) == '/') {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
    }
}
