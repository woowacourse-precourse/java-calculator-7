package calculator;

public class Parser {
    /**
     * 입력 문자열을 파싱하여 숫자 문자열 배열로 반환
     *
     * @param input 파싱할 입력 문자열.
     *              1. 빈 문자열
     *              2. 쉼표(,) 또는 콜론(:)으로 구분된 숫자들
     *              3. 커스텀 구분자를 사용한 숫자들 ("//{구분자}\\n{숫자들}" 형식)
     * @return 파싱된 숫자 문자열 배열
     */
    public static String[] parseNumbers(String input) {
        if (input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                numbers = input.substring(delimiterIndex + 2);
            }
        }

        return numbers.split(delimiter);
    }
}
