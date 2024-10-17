package calculator.separator.domain;

import calculator.separator.constant.RegexConstant;
import calculator.separator.util.SeparatorConvertor;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum RegexPattern {
    ONLY_NUMBER_SEPARATOR(RegexConstant.ONLY_NUMBER_SEPARATOR_REGEX),
    CUSTOM_SEPARATOR(RegexConstant.CUSTOM_SEPARATOR_REGEX) {
        @Override
        public String extractCustomSeparator(String input) {
            int startWith = SeparatorConvertor.forWardSlashStartWithIndex(input);
            int endWith = SeparatorConvertor.slashNextLineEndWithIndex(input);
            String customSeparator = SeparatorConvertor.createCustomSeparator(input, startWith, endWith);
            return SeparatorConvertor.addCustomSeparator(customSeparator);
        }
        @Override
        public String extractNumber(String input) {
            int startWith = SeparatorConvertor.slashNextLineStartWithIndex(input);
            return SeparatorConvertor.createNumber(input, startWith);
        }
    },
    BLANK(RegexConstant.BLANK_REGEX);
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public static final RegexPattern[] REGEX_PATTERNS = values();

    public static boolean isMatch(String input) {
        return Arrays.stream(REGEX_PATTERNS)
                .anyMatch((regexPattern) -> regexPattern.match(input));
    }
    public static String extractNumberProcess(String input) {
        return Arrays.stream(REGEX_PATTERNS)
                .filter((regexPattern) -> regexPattern.match(input))
                .findFirst()
                .map((regexPattern) -> regexPattern.extractNumber(input))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 발생"));
    }
    public static String extractCustomSeparatorProcess(String input) {
        return Arrays.stream(REGEX_PATTERNS)
                .filter((regexPattern) -> regexPattern.match(input))
                .findFirst()
                .map((regexPattern) -> regexPattern.extractCustomSeparator(input))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 발생"));
    }
    private boolean match(String input) {
        return pattern.matcher(input).matches();
    }

    public String extractCustomSeparator(String input) {
        return SeparatorConvertor.defaultSeparator();
    }
    public String extractNumber(String input) {
        return input;
    }
}
