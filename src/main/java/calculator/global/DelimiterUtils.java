package calculator.global;

public class DelimiterUtils {

    /**
     * 주어진 입력 문자열에서 "\n"의 첫 번째 등장 위치를 찾는다.
     *
     * @param input "\n"을 찾을 입력 문자열
     * @return "\n"의 첫 번째 등장 위치 인덱스, 찾지 못했다면 -1을 반환.
     */
    public static int findNewlineIndex(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                return i;
            }
        }
        return -1;
    }
}
