package calculator;

import java.util.List;

public class ValidateInput {
    public static void isValidInput(String input, List<Character> indexers) {
        boolean lastWasIndexer = false; // 마지막 문자가 구분자였는지 추적

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) && !isIndexer(ch, indexers)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            // 현재 문자가 구분자인 경우
            if (isIndexer(ch, indexers)) {
                if (lastWasIndexer) { // 이전 문자가 구분자였다면
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                lastWasIndexer = true; // 현재 문자가 구분자이므로 true로 설정
            } else {
                lastWasIndexer = false; // 현재 문자가 숫자이면 false로 설정
            }
        }
    }

    // 구분자 체크 메서드
    private static boolean isIndexer(char ch, List<Character> indexers) {
        for (char indexer : indexers) {
            if (ch == indexer) {
                return true;
            }
        }
        return false;
    }
}
