package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.StringSeparatorService;
import calculator.exception.InvalidSplitStrException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SplitStrListValidatorTest {

    @ParameterizedTest
    @MethodSource("provideSplitStrBySeparatorsAndExpectedNumberList")
    void 구분자로_분리된_문자열_리스트를_숫자_리스트로_변환하는_테스트(List<String> splitStrBySeparators, List<Long> expectedNumberList) {
        StringSeparatorService stringSeparatorService = new StringSeparatorService();
        assertThat(stringSeparatorService.makeNumberList(splitStrBySeparators)).isEqualTo(expectedNumberList);
    }

    private static Stream<Arguments> provideSplitStrBySeparatorsAndExpectedNumberList() {
        return Stream.of(
                Arguments.of(List.of("123", "12", "3"), List.of(123L, 12L, 3L)),
                Arguments.of(List.of("12345"), List.of(12345L)),
                Arguments.of(List.of("1234567890123456789", "1234567890", "123456789012345"),
                        List.of(1234567890123456789L, 1234567890L, 123456789012345L))
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidSplitStrBySeparators")
    void 구분자로_분리된_문자열_리스트를_숫자_리스트로_변환하는데_실패하여_예외를_발생시키는_테스트(List<String> splitStrBySeparators) {
        SplitStrListValidator splitStrListValidator = new SplitStrListValidator();
        assertThatThrownBy(() -> splitStrListValidator.makeNumberList(splitStrBySeparators))
                .isInstanceOf(InvalidSplitStrException.class);
    }

    private static Stream<Arguments> provideInvalidSplitStrBySeparators() {
        return Stream.of(
                Arguments.of(List.of("123\\", "12", "3e", "12345")),
                Arguments.of(List.of("3", "4", "56", "n")),
                Arguments.of(List.of("12345678901234567890"))
        );
    }
}