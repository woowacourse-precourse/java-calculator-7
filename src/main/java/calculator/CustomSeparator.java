package calculator;

public class CustomSeparator {

    public String separator(String st) {
        // 기본 구분자
        String separator = "[,:";

        // 만약 "/"로 시작하면 커스텀 구분자가 존재한다는 의미
        if (st.startsWith("/")) {
            separator += st.substring(2, st.indexOf("\\"));
        }

        separator += "]";
        return separator;
    }

}
