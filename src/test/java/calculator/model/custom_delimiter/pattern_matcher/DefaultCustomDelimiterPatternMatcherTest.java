package calculator.model.custom_delimiter.pattern_matcher;

import calculator.util.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DefaultCustomDelimiterPatternMatcher 클래스")
class DefaultCustomDelimiterPatternMatcherTest {

    private static final DefaultCustomDelimiterPatternMatcher defaultCustomDelimiterPatternMatcher =
            new DefaultCustomDelimiterPatternMatcher();
    private static final String prefix = defaultCustomDelimiterPatternMatcher.DELIMITER_PREFIX;
    private static final String suffix = StringUtils.unescapeDoubleBackslashes(
            defaultCustomDelimiterPatternMatcher.DELIMITER_SUFFIX
    );

    static Stream<Arguments> provideValidInput() {
        return Stream.of(
                Arguments.of(prefix + ";" + suffix + "1;2", ";"),
                Arguments.of(prefix + "," + suffix + "1,2", ","),
                Arguments.of(prefix + "." + suffix + "1.2", "."),
                Arguments.of(prefix + "|" + suffix + "1|2", "|"),
                Arguments.of(prefix + "=" + suffix + "1=2", "=")
        );
    }

    static Stream<Arguments> provideInvalidInput() {
        return Stream.of(
                Arguments.of("1,2"),
                Arguments.of("1;2"),
                Arguments.of("1.2"),
                Arguments.of("1|2"),
                Arguments.of("1=2"),
                Arguments.of("123")
        );
    }

    @ParameterizedTest(name = "올바른 형식: {0}")
    @MethodSource("provideValidInput")
    void 올바른_형식은_매칭에_성공한다(String validInput) {

        // when
        Matcher matcher = defaultCustomDelimiterPatternMatcher.match(validInput);

        // then
        assertTrue(matcher.matches());
    }

    @ParameterizedTest(name = "올바르지 않은 형식: {0}")
    @MethodSource("provideInvalidInput")
    void 올바르지_않은_형식은_매칭에_실패한다(String invalidInput) {

        // when
        Matcher matcher = defaultCustomDelimiterPatternMatcher.match(invalidInput);

        // then
        assertFalse(matcher.matches());
    }

    @ParameterizedTest(name = "올바른 형식: {0}, 구분자: {1}")
    @MethodSource("provideValidInput")
    void 올바른_형식이면_구분자가_추출된다(String validInput, String customDelimiter) {

        // when
        Optional<String> delimiter = defaultCustomDelimiterPatternMatcher.extractDelimiterGroup(validInput);

        // then
        assertTrue(delimiter.isPresent());
        assertEquals(customDelimiter, delimiter.get());
    }

    @ParameterizedTest(name = "올바르지 않은 형식: {0}")
    @MethodSource("provideInvalidInput")
    void 올바르지_않은_형식이면_구분자가_추출되지_않는다(String invalidInput) {

        // when
        Optional<String> delimiter = defaultCustomDelimiterPatternMatcher.extractDelimiterGroup(invalidInput);

        // then
        assertFalse(delimiter.isPresent());
    }

    @ParameterizedTest(name = "올바른 형식: {0}")
    @MethodSource("provideValidInput")
    void 커스텀_구분자가_있다면_떼어진다(String validInput) {

        // when
        Optional<String> trimmedGroup = defaultCustomDelimiterPatternMatcher.extractTrimmedGroup(validInput);

        // then
        String expected = validInput.substring(validInput.indexOf(suffix) + suffix.length());
        assertTrue(trimmedGroup.isPresent());
        assertEquals(expected, trimmedGroup.get());
    }

    @ParameterizedTest(name = "올바르지 않은 형식: {0}")
    @MethodSource("provideInvalidInput")
    void 커스텀_구분자가_없다면_떼어지지_않는다(String invalidInput) {

        // when
        Optional<String> trimmedGroup = defaultCustomDelimiterPatternMatcher.extractTrimmedGroup(invalidInput);

        // then
        assertFalse(trimmedGroup.isPresent());
    }
}
