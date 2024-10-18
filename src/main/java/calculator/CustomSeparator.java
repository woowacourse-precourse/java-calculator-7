package calculator;

public class CustomSeparator {

    public String separator(String st) {
        // 기본 구분자
        String separator = "[,:";

        // "//"와 "\n" 사이에 있는 값을 하나씩 구분자에 추가해주기 위해 배열로 변환
        String[] stSplit = st.split("");

        // 만약 "/"로 시작하면 커스텀 구분자가 존재한다는 의미
        if (st.startsWith("/")) {
            // "\n" 문자가 나올 때까지 모든 문자를 separator에 추가
            for (int i = 2; i < st.indexOf("\\"); i++) {
                separator += stSplit[i];
            }
        }
        separator += "]";
        return separator;
    }

}
