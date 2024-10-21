package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {
    private static final String REGEX_OR = "|";
    private static final Set<Delimiter> DEFAULT_DELIMITERS = Set.of(Delimiter.from(","), Delimiter.from(":"));

    private final Set<Delimiter> value;

    private Delimiters(Set<Delimiter> delimiters) {
        this.value = delimiters;
    }

    public static Delimiters createWithDefault() {
        return new Delimiters(DEFAULT_DELIMITERS);
    }

    public static Delimiters createWithCustom(List<Delimiter> customDelimiters) {
        if (customDelimiters == null) {
            throw new IllegalArgumentException("커스텀 구분자목록은 null 일 수 없습니다.");
        }

        Set<Delimiter> allDelimiters = new HashSet<>(DEFAULT_DELIMITERS);
        allDelimiters.addAll(customDelimiters);
        return new Delimiters(allDelimiters);
    }

    public String createRegexPattern() {
        return value.stream()
                .map(delimiter -> Pattern.quote(delimiter.getValue()))
                .collect(Collectors.joining(REGEX_OR));
    }
}