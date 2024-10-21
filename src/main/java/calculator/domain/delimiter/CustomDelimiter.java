package calculator.domain.delimiter;

import calculator.util.Constants;

/**
 * 구분자 중에서 미리 정해지 않은 구분자를 나타낸 클래스로
 * 입력된 문자열 맨 앞 "//" 와 "\n" 문자열 사이에 위치한 문자로 정의한다.
 */
public class CustomDelimiter implements Delimiter {

    public static final String headSpecifierOfCustomDelimiter = "//";
    public static final String tailSpecifierOfCustomDelimiter = "\\n";

    private final String symbol;

    private CustomDelimiter(String symbol) {
        this.symbol = symbol;
    }

    public static CustomDelimiter getFromLineAfterValidateElseNull(String targetLine) {
        if (hasLineSpecifierOfCustomDelimiter(targetLine)) {
            String symbolOfCustomDelimiter =
                    targetLine.substring(2, targetLine.lastIndexOf(tailSpecifierOfCustomDelimiter));
            if (symbolOfCustomDelimiter.isEmpty()) {
                throw new IllegalArgumentException(Constants.exceptionMessagePrefix +
                        "커스텀 구분자를 지정하는 문자만 있습니다.");
            }
            return new CustomDelimiter(symbolOfCustomDelimiter);
        }
        return null;
    }

    private static boolean hasLineSpecifierOfCustomDelimiter(String targetLine) {
        return targetLine.startsWith(headSpecifierOfCustomDelimiter) &&
                targetLine.contains(tailSpecifierOfCustomDelimiter);
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}