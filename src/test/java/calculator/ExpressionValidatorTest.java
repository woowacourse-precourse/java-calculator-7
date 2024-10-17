package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExpressionValidatorTest {

    @ParameterizedTest
    @DisplayName("양수와 Separator로만 이루어진 유효한 계산식 검증 확인")
    @MethodSource("generateExpressionData")
    void testIsValidateExpression(Separators separators, String expression, boolean expected) {
        ExpressionValidator validator = new ExpressionValidator(separators);

        assertThat(validator.isValidateExpression(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> generateExpressionData() {
        return Stream.of(
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2:3", true),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), ",1,2:3", false),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2:3,", false),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2::3,", false),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), "1,2:4aa3", true),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), ",1,2:aa3", false)
        );
    }

    private static Separators generateSeparatorsFrom(List<String> separatorString) {
        return new Separators(separatorString.stream().map(Separator::new).collect(Collectors.toSet()));
    }
}