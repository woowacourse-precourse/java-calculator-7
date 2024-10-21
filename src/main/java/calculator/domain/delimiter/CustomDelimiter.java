package calculator.domain.delimiter;

import calculator.util.Constants;

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