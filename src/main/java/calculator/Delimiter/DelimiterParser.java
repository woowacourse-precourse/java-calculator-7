package calculator.Delimiter;

import java.util.ArrayList;

public final class DelimiterParser {
    private final ArrayList<Delimiter> delimiters;

    public DelimiterParser(ArrayList<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public String[] parse(String input) {
        for (Delimiter delimiter : delimiters) {
            if (delimiter.supports(input)) {
                return delimiter.splitStringArray(input);
            }
        }
        throw new IllegalArgumentException("잘못된 형식의 값을 입력하였습니다" + input);
    }

}
