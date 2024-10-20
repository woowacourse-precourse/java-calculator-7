package calculator.regex.domain;

import calculator.constant.ErrorMessage;
import calculator.regex.constant.SeparatorConvertorConstant;
import calculator.sentence.dto.Sentence;
import calculator.regex.constant.RegexConstant;
import calculator.regex.util.SeparatorConvertor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum RegexPattern {
    DEFAULT_SEPARATOR(RegexConstant.DEFAULT_SEPARATOR_REGEX),
    DEFAULT_DOUBLE_SEPARATOR(RegexConstant.DEFAULT_SEPARATOR_DOUBLE_REGEX),
    CUSTOM_SEPARATOR(RegexConstant.CUSTOM_SEPARATOR_REGEX) {
        @Override
        public String extractSeparator(String input) {
            String customSeparator = SeparatorConvertor.createCustomSeparator(input);
            return SeparatorConvertor.replaceRegex(customSeparator);
        }

        @Override
        public List<String> extractNumber(String input, String separator) {
            String extractNumber = SeparatorConvertor.createNumber(input);
            return Arrays.stream(extractNumber.split(separator)).toList();
        }
    },
    CUSTOM_SEPARATOR_DOUBLE(RegexConstant.CUSTOM_SEPARATOR_DOUBLE_REGEX) {
        @Override
        public String extractSeparator(String input) {
            String customSeparator = SeparatorConvertor.createCustomSeparator(input);
            return SeparatorConvertor.replaceRegex(customSeparator);
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
        return SeparatorConvertorConstant.DEFAULT_SEPARATOR;
    }

    public List<String> extractNumber(String input, String separator) {
        return Arrays.stream(input.split(separator)).toList();
    }
    private boolean match(String input) {
        return pattern.matcher(input).matches();
    }
    public static RegexPattern getRegexPattern(Sentence sentence) {
        return Arrays.stream(REGEX_PATTERNS)
                .filter((regexPattern) -> regexPattern.match(sentence.getSentence()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }
}
