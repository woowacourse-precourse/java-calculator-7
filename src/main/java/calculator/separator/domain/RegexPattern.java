package calculator.separator.domain;

import calculator.constant.ErrorMessage;
import calculator.separator.constant.RegexConstant;
import calculator.separator.util.SeparatorConvertor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum RegexPattern {
    ONLY_NUMBER_SEPARATOR(RegexConstant.ONLY_NUMBER_SEPARATOR_REGEX),
    CUSTOM_SEPARATOR(RegexConstant.CUSTOM_SEPARATOR_REGEX) {
        @Override
        public String extractSeparator(String input) {
            String customSeparator = SeparatorConvertor.createCustomSeparator(input);
            return SeparatorConvertor.replaceEscape(customSeparator);
        }

        @Override
        public List<String> extractNumber(String input, String separator) {
            String extractNumber = SeparatorConvertor.createNumber(input);
            return Arrays.stream(extractNumber.split(separator))
                    .toList();
        }
    },
    BLANK(RegexConstant.BLANK_REGEX);
    public static final RegexPattern[] REGEX_PATTERNS = values();
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }


    public static boolean isMatch(String input) {
        return Arrays.stream(REGEX_PATTERNS)
                .anyMatch((regexPattern) -> regexPattern.match(input));
    }

    public static List<String> extractNumberProcess(String input) {
        return Arrays.stream(REGEX_PATTERNS)
                .filter((regexPattern) -> regexPattern.match(input))
                .findFirst()
                .map((regexPattern) -> {
                            String separator = regexPattern.extractSeparator(input);
                            return regexPattern.extractNumber(input, separator);
                        }
                ).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }

    public String extractSeparator(String input) {
        return DefaultSeparator.getDefaultSeparator();
    }

    public List<String> extractNumber(String input, String separator) {
        return Arrays.stream(input.split(separator)).toList();
    }
    private boolean match(String input) {
        return pattern.matcher(input).matches();
    }
}
