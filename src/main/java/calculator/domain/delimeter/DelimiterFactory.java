package calculator.domain.delimeter;

import java.util.List;

public class DelimiterFactory {
    private DelimiterFactory() {
    }

    public static Delimiters createDelimitersFrom(List<String> delimiterStrings) {
        List<Delimiter> customDelimiters = parseDelimiters(delimiterStrings);

        return customDelimiters.isEmpty() ? Delimiters.createWithDefault()
                : Delimiters.createWithCustom(customDelimiters);
    }

    private static List<Delimiter> parseDelimiters(List<String> delimiterStrings) {
        return delimiterStrings.stream()
                .map(Delimiter::from)
                .toList();
    }

}
