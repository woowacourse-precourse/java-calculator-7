package calculator.model.custom_delimiter.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("DefaultCustomDelimiterValidator 클래스")
public class DefaultCustomDelimiterValidatorTest {

    private final DefaultCustomDelimiterValidator
            defaultCustomDelimiterValidator = new DefaultCustomDelimiterValidator();

    static Stream<Arguments> provideValidDelimiters() {
        return Stream.of(
                Arguments.of(";"),
                Arguments.of(","),
                Arguments.of("|"),
                Arguments.of("]"),
                Arguments.of(";"),
                Arguments.of("[")
        );
    }

    static Stream<Arguments> provideBlankDelimiters() {
        return Stream.of(
                Arguments.of("", IllegalArgumentException.class),
                Arguments.of(" ", IllegalArgumentException.class)
        );
    }

    static Stream<Arguments> provideEscapeDelimiters() {
        return Stream.of(
                Arguments.of("\\;", IllegalArgumentException.class),
                Arguments.of("\\,", IllegalArgumentException.class),
                Arguments.of("\\|", IllegalArgumentException.class),
                Arguments.of("\\]", IllegalArgumentException.class),
                Arguments.of("\\[", IllegalArgumentException.class)
        );
    }

    static Stream<Arguments> provideNumberDelimiters() {
        return Stream.of(
                Arguments.of("1", IllegalArgumentException.class),
                Arguments.of("a1", IllegalArgumentException.class),
                Arguments.of("1a", IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "구분자: {0}")
    @MethodSource("provideValidDelimiters")
    void 정상적인_구분자는_통과한다(String delimiter) {

        // when & then
        assertDoesNotThrow(() -> defaultCustomDelimiterValidator.validate(delimiter));
    }

    @ParameterizedTest(name = "구분자: {0}")
    @MethodSource("provideBlankDelimiters")
    void 구분자가_비어있으면_예외가_발생한다(String delimiter, Class<? extends RuntimeException> exceptionClass) {

        // when & then
        assertThrows(exceptionClass, () -> defaultCustomDelimiterValidator.validate(delimiter));
    }

    @ParameterizedTest(name = "구분자: {0}")
    @MethodSource("provideEscapeDelimiters")
    void 구분자에_백슬래시가_있으면_예외가_발생한다(String delimiter, Class<? extends RuntimeException> exceptionClass) {

        // when & then
        assertThrows(exceptionClass, () -> defaultCustomDelimiterValidator.validate(delimiter));
    }

    @ParameterizedTest(name = "구분자: {0}")
    @MethodSource("provideNumberDelimiters")
    void 구분자에_숫자가_있으면_예외가_발생한다(String delimiter, Class<? extends RuntimeException> exceptionClass) {

        // when & then
        assertThrows(exceptionClass, () -> defaultCustomDelimiterValidator.validate(delimiter));
    }
}
