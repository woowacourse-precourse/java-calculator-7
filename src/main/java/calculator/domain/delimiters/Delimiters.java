package calculator.domain.delimiters;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

