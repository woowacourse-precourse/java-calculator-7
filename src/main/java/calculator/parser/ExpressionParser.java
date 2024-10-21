package calculator.parser;

import java.util.HashSet;
import java.util.Set;

public class ExpressionParser implements Parser {

    private final Set<String> delimiters = new HashSet<>();
    private final String startToken = "//";
    private final String endToken = "\\n";
    private final String TOKEN_STRING = "TOKEN";

    // 
    public ExpressionParser() {
        delimiters.add(",");
        delimiters.add(":");
    }

    // think: String을 다루고 분할하므로, 리턴 타입을 String[]이 낫겠다.
    // think: split() 내부에서, setDelimiters()를 호출하는 게 맞을까?
    @Override
    public String[] split(String value) {
        
        if (isExistsCustomDelimiter(value)) {
            value = stripCustomDelimiter(value);
        }

        value = replaceToken(stripCustomDelimiter(value));

        return value.split(TOKEN_STRING);
    }

    // note: 구분자 설정
    @Override
    public void setDelimiters(String value) {
        if (isExistsCustomDelimiter(value)) {
            delimiters.add(findDelimiter(value));
        }
    }

    private String findDelimiter(String value) {
        int startTokenIndex = value.indexOf(startToken);
        int endTokenIndex = value.indexOf(endToken);

        // 찾은 커스텀 구분자 리턴
        return value.substring(startTokenIndex + startToken.length(), endTokenIndex);
    }

    private String replaceToken(String value) {
        return delimiters.stream()
                .reduce(value, (s, delimiter) -> {
                    return s.replace(delimiter, TOKEN_STRING);
                });
    }

    private String stripCustomDelimiter(String value) {
        int endTokenIndex = value.indexOf(endToken);

        if (endTokenIndex == -1) {
            return value;
        }

        return value.substring(endTokenIndex + endToken.length());
    }

    private boolean isExistsCustomDelimiter(String value) {
        return value.contains(startToken) && value.contains(endToken);
    }
}
