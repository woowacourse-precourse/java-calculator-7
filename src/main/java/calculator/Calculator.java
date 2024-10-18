package calculator;

public class Calculator {

    private static final char BASIC1 = ',';
    private static final char BASIC2 = ':';

    public int splitStr(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int idx = s.indexOf("//");

        // 커스텀 구분자 있을 경우
        if (idx != -1) {
            if (s.charAt(idx + 3) == '\\' && s.charAt(idx + 4) == 'n') {
                char custom = s.charAt(idx + 2);

                String sliceS = customDelimiterDelete(s, idx);

                String[] customArr = sliceS.split(BASIC1 + "|" + BASIC2 + "|" + custom);
                // TODO 반복문 돌며 양수 아닌값 있을 시 예외처리 후 종료
                // TODO 양수만 있다면 합 반환
            }
        }
        // 커스텀 구분자 없을 경우
        String[] defaultArr = s.split("BASIC1|BASIC2");
        // TODO 반복문 돌며 양수 아닌값 있을 시 예외처리 후 종료
        // TODO 양수만 있다면 합 반환
    }

    // 커스텀 구분자 부분 삭제 함수
    private String customDelimiterDelete(String s, int idx) {
        String slice1 = s.substring(0, idx);
        String slice2 = s.substring(idx+5);

        return slice1 + slice2;
    }
}
