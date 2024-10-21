package calculator;

public class CustomSeparator {

    // 구분자가 있을 경우 문자열 슬라이싱을 시작할 위치
    private static final int SLICE_START = 2;

    public String separator(String st) {
        // 기본 구분자
        String separator = "[,:";

        // 만약 "/"로 시작하면 커스텀 구분자가 존재한다는 의미
        if (st.startsWith("/")) {
            separator += st.substring(SLICE_START, st.indexOf("\\"));
        }

        separator += "]";
        return separator;
    }

}
