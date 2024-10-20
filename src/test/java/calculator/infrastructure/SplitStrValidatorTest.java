package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.common.exception.InvalidateArithmeticNumberException;
import calculator.common.exception.OutOfLongRangeException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SplitStrValidatorTest {

    private SplitStrValidator splitStrValidator;

    @BeforeEach
    void setUp() {
        splitStrValidator = new SplitStrValidator();
    }

    @ParameterizedTest
    @MethodSource("provideSplitStrBySeparatorsAndExpectedNumberList")
    void 구분자로_분리된_문자열_리스트를_숫자_리스트로_변환하는_테스트(String[] splitStrBySeparators, List<Long> expectedNumberList) {
        assertThat(splitStrValidator.makeNumberList(splitStrBySeparators)).isEqualTo(expectedNumberList);
    }

    private static Stream<Arguments> provideSplitStrBySeparatorsAndExpectedNumberList() {
        return Stream.of(
                Arguments.of(new String[]{"012", "0012", "0001234567890", "00000000000000000000",
                                "00000000000000000000000000000000000000000000000"},
                        List.of(12L, 12L, 1234567890L, 0L, 0L)),
                Arguments.of(new String[]{"123", "12", "3"}, List.of(123L, 12L, 3L)),
                Arguments.of(new String[]{"12345"}, List.of(12345L)),
                Arguments.of(new String[]{"1234567890123456789", "1234567890", "123456789012345"},
                        List.of(1234567890123456789L, 1234567890L, 123456789012345L))
        );
    }


    @ParameterizedTest
    @MethodSource("provideInvalidSplitStrBySeparators")
    void 구분자로_분리된_문자열_리스트에_숫자가_아닌_문자가_포함되어_예외를_발생시키는_테스트(String[] splitStrBySeparators) {
        assertThatThrownBy(() -> splitStrValidator.makeNumberList(splitStrBySeparators))
                .isInstanceOf(InvalidateArithmeticNumberException.class);
    }

    private static Stream<Arguments> provideInvalidSplitStrBySeparators() {
        return Stream.of(
                Arguments.of((Object) new String[]{"123\\", "12", "3e", "12345"}),
                Arguments.of((Object) new String[]{"3", "4", "56", "n"}),
                Arguments.of((Object) new String[]{"-123", "-1234", "+-123", "-321"}),
                Arguments.of((Object) new String[]{"+123", "+12345", "+567890", "+-0"})
        );
    }

    @Test
    void 구분자로_분리된_문자열_리스트의_숫자가_범위를_벗어나_예외를_발생시키는_테스트() {
        String[] numbers = new String[]{"12345678901234567890", "1234567890987654321"};
        assertThatThrownBy(() -> splitStrValidator.makeNumberList(numbers))
                .isInstanceOf(OutOfLongRangeException.class);
    }
}