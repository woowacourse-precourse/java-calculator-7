package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ExpressionParserTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 계산식이면 IllegalArgumentException을 던지는지 확인")
    @MethodSource("generateIllegalExpressionData")
    void testParseThrowIllegalArgumentException(Separators separators, String expressionString) {
        ExpressionParser parser = generateParserFrom(separators);

        assertThatThrownBy(() -> parser.parse(expressionString)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateIllegalExpressionData() {
        return Stream.of(
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), ",1,2:3"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2:3,"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2::3,"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), ",1,2:aa3")
        );
    }

    @ParameterizedTest
    @DisplayName("올바른 계산식 parse시 IllegalArgumentException을 던지지 않는지 확인")
    @MethodSource("generateLegalExpressionData")
    void testParseNotThrowIllegalArgumentException(Separators separators, String expressionString) {
        ExpressionParser parser = generateParserFrom(separators);

        assertThatNoException().isThrownBy(() -> parser.parse(expressionString));
    }

    static Stream<Arguments> generateLegalExpressionData() {
        return Stream.of(
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2:3"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",")), "1,2:3"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), "1,2aa3"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), "1"),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), ""),
                Arguments.of(generateSeparatorsFrom(List.of(":", ",", "aa")), "")
        );
    }

    private static ExpressionParser generateParserFrom(Separators separators) {
        ExpressionValidator validator = new ExpressionValidator(separators);
        ExpressionParser parser = new ExpressionParser(validator, separators);
        return parser;
    }

    private static Separators generateSeparatorsFrom(List<String> separatorString) {
        return new Separators(separatorString.stream().map(Separator::new).collect(Collectors.toSet()));
    }

}