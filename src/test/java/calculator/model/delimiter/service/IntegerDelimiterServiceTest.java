package calculator.model.delimiter.service;

import calculator.model.custom_delimiter.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import calculator.model.delimiter.factory.DelimiterFactory;
import calculator.model.delimiter.factory.DelimitersFactory;
import calculator.util.pattern.PatternUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("IntegerDelimiterService 클래스")
public class IntegerDelimiterServiceTest {

    private final DelimitersFactory delimitersFactory =
            new TestDelimitersFactory();
    private final CustomDelimiterService customDelimiterService =
            new TestCustomDelimiterService(new TestDelimiterFactory((value) -> {
            }), new TestCustomDelimiterPatternMatcher());
    private final IntegerDelimiterService integerDelimiterService =
            new IntegerDelimiterService(delimitersFactory, customDelimiterService);
    private final String EMPTY_STRING = "";

    static List<Arguments> provideValidInput() {
        return List.of(
                Arguments.of("1", List.of("1")),
                Arguments.of("1,2", List.of("1", "2")),
                Arguments.of("", List.of("")),
                Arguments.of("//;\\n1;2;3", List.of("1", "2", "3")),
                Arguments.of("1,2,3", List.of("1", "2", "3")),
                Arguments.of("//.\\n1.2:3", List.of("1", "2", "3"))
        );
    }

    static List<Arguments> provideEmptyInput() {
        return List.of(
                Arguments.of(""),
                Arguments.of("//;\\n"),
                Arguments.of("//.\\n")
        );
    }

    static List<Arguments> provideUndefinedDelimiterInput() {
        return List.of(
                Arguments.of("//[\\n1;2.3[4"),
                Arguments.of("1-2:3"),
                Arguments.of("1+2.3")
        );
    }


    @ParameterizedTest(name = "문자열: {0}, 기대값: {1}")
    @MethodSource("provideValidInput")
    void 문자열을_구분자로_분리한다(String value, List<String> expected) {

        // when
        List<String> result = integerDelimiterService.splitByDelimiters(value);

        // then
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideEmptyInput")
    void 빈_문자열은_빈_문자열로_반환한다(String value) {

        // when
        List<String> result = integerDelimiterService.splitByDelimiters(value);

        // then
        assertThat(result).containsExactly(EMPTY_STRING);
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideUndefinedDelimiterInput")
    void 정의되지_않은_구분자가_포함된_경우_예외를_발생시킨다(String value) {

        // when & then
        assertThatThrownBy(() -> integerDelimiterService.splitByDelimiters(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class TestCustomDelimiterService extends CustomDelimiterService {

        public TestCustomDelimiterService(
                DelimiterFactory delimiterFactory,
                CustomDelimiterPatternMatcher customDelimiterPatternMatcher) {
            super(delimiterFactory, customDelimiterPatternMatcher);
        }
    }

    private static class TestDelimiterFactory extends DelimiterFactory {

        public TestDelimiterFactory(DelimiterValidator delimiterValidator) {
            super(delimiterValidator);
        }

        @Override
        public Delimiter createDelimiter(String value) {
            delimiterValidator.validate(value);
            value = PatternUtils.escapeSpecialCharacters(value);
            return new Delimiter(value);
        }
    }

    private static class TestDelimitersFactory extends DelimitersFactory {

        private final List<Delimiter> defaultDelimiters = List.of(
                new Delimiter(","),
                new Delimiter(":")
        );

        @Override
        public Delimiters createDelimiters(Delimiter... additionalDelimiters) {
            List<Delimiter> delimiters = new ArrayList<>(defaultDelimiters);
            delimiters.addAll(Arrays.asList(additionalDelimiters));
            return new Delimiters(delimiters);
        }
    }

    private static class TestCustomDelimiterPatternMatcher implements CustomDelimiterPatternMatcher {

        private final String DELIMITER_PREFIX = "//";
        private final String DELIMITER_SUFFIX = "\\\\n";
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
