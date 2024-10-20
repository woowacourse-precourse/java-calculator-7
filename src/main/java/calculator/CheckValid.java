package calculator;

public class CheckValid {

    // 숫자의 유효성을 확인하는 메서드
    static void isValidNum(String word) {
        // 숫자가 아닌 경우 예외 처리
        try {
            int num = Integer.parseInt(word);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + word);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다: " + word);
        }
    }

    // 문자열에 공백이 포함되어 있는지 확인하는 메서드
    static void isValidString(String word) {
        if (word == null || word.isEmpty()) {
            return;  // 빈 문자열은 허용
        }

        // 숫자 또는 구분자 앞뒤에 공백이 있으면 예외 발생
        if (word.startsWith(" ") || word.endsWith(" ")) {
            throw new IllegalArgumentException("숫자나 구분자 앞뒤에 공백이 포함되어 있습니다: '" + word + "'");
        }
    }

    // 구분자가 연속으로 있는지 확인하는 메서드
    static void checkContinuousDelimiters(String input) {
        int nonNumericCount = 0; // 숫자가 아닌 문자의 개수
        char[] chars = input.toCharArray(); // 문자열을 문자 배열로 변환
        System.out.println(chars);
        for (char c : chars) {
            // 숫자가 아닌 경우
            if (!Character.isDigit(c) && c != ' ' && c != '-' && !Character.isAlphabetic(c)) {
                nonNumericCount++;
                // 연속적으로 2개 이상 발견한 경우
                if (nonNumericCount >= 2) {
                    throw new IllegalArgumentException("구분자가 연속으로 사용되었습니다.");
                }
            } else {
                nonNumericCount = 0; // 숫자인 경우 카운트 초기화
            }
        }
    }
}
