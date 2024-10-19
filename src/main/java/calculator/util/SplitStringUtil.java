package calculator.util;

public class SplitStringUtil {

    /**
     * 입력 문자열을 구분자 문자열과 숫자 문자열로 나누는 유틸리티 메서드. 첫 번째 문자가 문자이면 숫자가 나올 때까지가 커스텀 구분자 문자열, 첫 번째 문자가 숫자이면 구분자 문자열은 없음.
     *
     * @param input 입력 문자열
     * @return 구분자 문자열과 숫자 문자열 배열 [separator, numbers]
     */
    public static String[] splitInputString(String input) {
        if (isZeroIndexCharacter(input)) {
            return handleCustomSeparatorString(input);
        }
        return new String[]{"", input};  // 첫 번째 문자가 숫자이면 커스텀 구분자 없음
    }

    /**
     * 숫자가 나올 때까지 커스텀 구분자 문자열로 간주.
     *
     * @param input 입력 문자열
     * @return 구분자 문자열과 숫자 문자열 배열 [separator, numbers]
     */
    private static String[] handleCustomSeparatorString(String input) {
        StringBuilder separator = new StringBuilder();
        int i = 0;
        while (i < input.length() && !Character.isDigit(input.charAt(i))) {
            separator.append(input.charAt(i));
            i++;
        }
        String numbers = input.substring(i);
        return new String[]{separator.toString(), numbers};
    }

    /**
     * 첫 번째 문자가 문자로 시작하는지 확인.
     *
     * @param input 입력 문자열
     * @return 첫 문자가 문자면 true, 숫자면 false
     */
    private static boolean isZeroIndexCharacter(String input) {
        return !Character.isDigit(input.charAt(0));
    }
}
