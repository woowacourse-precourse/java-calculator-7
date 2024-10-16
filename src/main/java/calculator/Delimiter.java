package calculator;

import java.util.Arrays;
import java.util.List;

public enum Delimiter {

    /* 기본 구분자 */
    COMMA(",",true),
    COLON(":",true),

    /* 커스텀 구분자에 들어가면 안되는 문자 */
    INVALID_DOUBLE_SLASH("//",false),
    INVALID_NEWLINE("\\n",false),
    INVALID_BLANK(" ",false),
    INVALID_NUMBER("[0-9]", false);

    private final String delimiter;
    private final boolean isBasic;

    Delimiter(String delimiter, boolean isBasic) {
        this.delimiter = delimiter;
        this.isBasic = isBasic;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean isBasic() {
        return isBasic;
    }

    public static List<String> getBasicDelimiters() {
        return Arrays.stream(Delimiter.values())
                .filter(Delimiter::isBasic)
                .map(Delimiter::getDelimiter)
                .toList();
    }

    public static List<String> getInvalidCustomDelimiters() {
        return Arrays.stream(Delimiter.values())
                .filter(delimiter -> !delimiter.isBasic())
                .map(Delimiter::getDelimiter)
                .toList();
    }

}
