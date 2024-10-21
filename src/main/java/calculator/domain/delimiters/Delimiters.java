package calculator.domain.delimiters;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 구분자들을 담은 클래스
 * 구분자 생성기를 통해서만 객체를 만들 수 있음
 * 구분자로 문자열을 나누는 데 필요한 값을 반환하는 메서드들을 정의함
 */
public class Delimiters {

    private final List<Delimiter> delimiters;

    protected Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public String getStringWithOutCustomDelimiterSpecifierPart(String line) {
        Delimiter customDelimiter = getCustomDelimiterElseNull(delimiters);
        if (customDelimiter != null) {
            String CustomDelimiterSpecifierPart =
                    CustomDelimiter.headSpecifierOfCustomDelimiter
                            + customDelimiter.getSymbol()
                            + CustomDelimiter.tailSpecifierOfCustomDelimiter;
            return line.replace(CustomDelimiterSpecifierPart, "");
        }
        return line;
    }

    private Delimiter getCustomDelimiterElseNull(List<Delimiter> elements) {
        for (Delimiter delimiter : elements) {
            if (delimiter instanceof CustomDelimiter) {
                return delimiter;
            }
        }
        return null;
    }

    public String getRegex() {
        String orBetweenGrouping = ")|(";
        String prefixGrouping = "(";
        String suffixGrouping = ")";
        return delimiters.stream()
                .map(Delimiter::getSymbol)
                .map(Pattern::quote)
                .collect(Collectors.joining(orBetweenGrouping,
                        prefixGrouping, suffixGrouping));
    }
}

