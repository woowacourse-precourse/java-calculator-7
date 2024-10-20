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
     * 커스텀 구분자로 분리
     */
    public String[] customDelimiter(String input) {
        int start = input.indexOf("/") + 2;
        int end = input.indexOf("\\n");

        String delimiter = input.substring(start, end);
        delimiter = escapeCharacters(delimiter);

        String part = input.substring(end + 2);
        return part.split(delimiter);
    }

    /**
     * 특수 문자 이스케이프 처리
     */
    private String escapeCharacters(String delimiter) {
        return delimiter.replaceAll("([\\Q^$|(){}[]*+?\\\\.\\E])", "\\\\$1");
    }
}
