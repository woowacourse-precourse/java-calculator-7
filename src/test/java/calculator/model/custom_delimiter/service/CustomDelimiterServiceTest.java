package calculator.model.custom_delimiter.service;

import calculator.model.custom_delimiter.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import calculator.model.delimiter.factory.DelimiterFactory;
import calculator.model.delimiter.factory.DelimitersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CustomDelimiterService 클래스")
public class CustomDelimiterServiceTest {

    private final DelimiterValidator delimiterValidator = (value) -> {
    };
    private final DelimiterFactory delimiterFactory = new TestDelimiterFactory(delimiterValidator);
    private final CustomDelimiterService customDelimiterService =
            new CustomDelimiterService(delimiterFactory, new TestCustomDelimiterPatternMatcher());

    static Stream<Arguments> provideValidInput() {
        return Stream.of(
                Arguments.of("//" + ";" + "\\n" + "1;2", ";"),
                Arguments.of("//" + "," + "\\n" + "1,2", ","),
                Arguments.of("//" + "." + "\\n" + "1.2", "."),
                Arguments.of("//" + "|" + "\\n" + "1|2", "|"),
                Arguments.of("//" + "=" + "\\n" + "1=2", "=")
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

    @ParameterizedTest(name = "문자열: {0}, 커스텀 구분자: {1}")
    @MethodSource("provideValidInput")
    void 문자열에_커스텀_구분자가_존재한다면_추출된다(String validInput, String customDelimiter) {

        // when
        Optional<Delimiter> delimiter = customDelimiterService.extractCustomDelimiter(validInput);

        // then
        assertTrue(delimiter.isPresent());
        assertEquals(customDelimiter, delimiter.get().value());
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideInvalidInput")
    void 문자열에_커스텀_구분자가_존재하지_않는다면_추출되지_않는다(String invalidInput) {

        // when
        Optional<Delimiter> delimiter = customDelimiterService.extractCustomDelimiter(invalidInput);

        // then
        assertTrue(delimiter.isEmpty());
    }

    private static class TestDelimiterFactory extends DelimiterFactory {
        public TestDelimiterFactory(DelimiterValidator delimiterValidator) {
            super(delimiterValidator);
        }

        @Override
        public Delimiter createDelimiter(String value) {
            return new Delimiter(value);
        }
    }

    private static class TestDelimitersFactory extends DelimitersFactory {
        @Override
        public Delimiters createDelimiters(Delimiter... additionalDelimiters) {
            return new Delimiters(List.of(additionalDelimiters));
        }
    }

    private static class TestCustomDelimiterPatternMatcher implements CustomDelimiterPatternMatcher {

        public final String DELIMITER_PREFIX = "//";
        public final String DELIMITER_SUFFIX = "\\\\n";
        private final Pattern DELIMITER_PATTERN = Pattern.compile(
                "^" + DELIMITER_PREFIX + "(.*)" + DELIMITER_SUFFIX + "(.*)"
        );

        @Override
        public Matcher match(String value) {
            return DELIMITER_PATTERN.matcher(value);
        }

        @Override
        public Optional<String> extractDelimiterGroup(String value) {
            return matchAndFind(value).map(matcher -> matcher.group(1));
        }

        @Override
        public Optional<String> extractTrimmedGroup(String value) {
            return matchAndFind(value).map(matcher -> matcher.group(2));
        }

        private Optional<Matcher> matchAndFind(String value) {
            Matcher matcher = match(value);
            return matcher.find() ? Optional.of(matcher) : Optional.empty();
        }
    }
}
