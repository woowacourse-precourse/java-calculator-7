package calculator;

/**
 * 구분자를 통해 숫자를 분리하는 클래스입니다.
 */
public class Delimiter {

    /**
     * 기본 구분자(쉼표, 콜론)로 분리
     */
    public String[] defaultDelimiter(String input) {
        return input.split("[,:]");
    }

    /**
     * 커스텀 구분자 처리
     */
    public String[] customDelimiter(String input) {
        int start = input.lastIndexOf("/");
        int end = input.indexOf("\\n");
        String delimiter = input.substring(start + 1, end);

        // 파이프(|) 문자 처리
        if ("|".equals(delimiter)) {
            delimiter = "\\|";
        }

        String part = input.substring(end + 2);
        return part.split(delimiter);
    }
}
