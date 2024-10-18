package calculator;

public class Calculator {

    private static final char DEFAULT_DELIMITER1 = ',';
    private static final char DEFAULT_DELIMITER2 = ':';
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    public int splitStr(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자 있을 경우
        if (s.startsWith(CUSTOM_PREFIX)) {
            if (s.startsWith(CUSTOM_SUFFIX, 3)) {
                char custom = s.charAt(2);

                // 커스텀 구분자 부분 삭제
                String sliceS = s.substring(5);

                String[] customArr = sliceS.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2 + "|" + custom);
                // TODO 반복문 돌며 양수 아닌값 있을 시 예외처리 후 종료
                // TODO 양수만 있다면 합 반환
            } else {
                // TODO "\n" 없다면 예외처리 후 종료
            }
        }
        // 커스텀 구분자 없을 경우
        String[] defaultArr = s.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2);
        // TODO 반복문 돌며 양수 아닌값 있을 시 예외처리 후 종료
        // TODO 양수만 있다면 합 반환
    }

}
