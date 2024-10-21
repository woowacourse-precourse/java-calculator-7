package calculator.endIndexFinder;

public class EndIndexFinder {

    // 구분자 끝을 찾는 함수
    public static int findSeparatorEndIndex(String input) {
        if (input.startsWith("//")) { // "//"로 입력을 시작해야만 커스텀 구분자 입력 가능
            for (int i = 2; i < input.length(); i++) { // "//" 이후부터 끝까지 확인
                if (input.charAt(i) == '\\') { // "\" 발견 시
                    if (i < input.length() - 1 && input.charAt(i + 1) == 'n') { // "\n"이어야 끝이므로 확인
                        return Math.min(i + 2, input.length() - 1); // "\n"이면 다음 인덱스 반환
                    }
                }
            }
        }
        return 0; // 커스텀 구분자가 없는 경우
    }
}
