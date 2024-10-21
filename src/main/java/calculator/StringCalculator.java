package calculator;

class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String REGEX = "//(.)\\s*(.*)";

    /**
     * 문자열에서 숫자를 추출하고 더한 결과를 반환하는 메서드
     *
     * @param input 입력 문자열
     * @return 더한 결과 값
     */
    public static int add(String input) {
        // 3. 문자열 유효성 검사 1: 공백 문자열 처리
        if (isEmpty(input)) {
            return 0;
        }

        return 0;
    }

    /**
     * 입력된 문자열이 공백 또는 null인지 검사
     *
     * @param input 입력 문자열
     * @return 공백 문자열 여부
     */
    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

}
