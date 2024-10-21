package calculator;

import java.util.Arrays;

public class DelimiterManager {

    private String[] delimiters;

    public DelimiterManager() {
        // 기본 구분자로 ","와 ":" 설정
        delimiters = new String[]{",", ":"};
    }

    public String[] getDelimiters() {
        return delimiters;
    }

    public String addCustomDelimiter(String input) {
        // 커스텀 구분자가 있는지 확인 후 커스텀 구분자 추가
        if (input.startsWith("//")) {
            int indexOfDelimiter = input.indexOf("\\n");
            if (indexOfDelimiter == -1)
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            String customDelimiter = input.substring(2, indexOfDelimiter);
            delimiters = Arrays.copyOf(delimiters, delimiters.length + 1);
            delimiters[delimiters.length - 1] = customDelimiter;
            input = input.substring(indexOfDelimiter + 2);
        }
        return input;
    }
}
