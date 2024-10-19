package calculator.lexicalParser;

import calculator.arithmeticUnit.ArithmeticOperation;
import calculator.expression.Expression;
import calculator.operator.Operand;
import calculator.operator.Operator;
import calculator.operator.OperatorContainer;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ExpressionParserTest {
    private static final ArithmeticOperation DUMMY_OPERATION = new ArithmeticOperation((x, y) -> 0) {};
    private static final String EMPTY_STRING = "";

    @ParameterizedTest
    @DisplayName("유효하지 않은 계산식이면 IllegalArgumentException을 던지는지 확인")
    @MethodSource("generateIllegalExpressionData")
    void testParseThrowIllegalArgumentException(OperatorContainer operatorContainer, String expressionString) {
        ExpressionParser parser = new ExpressionParser(operatorContainer);

        assertThatThrownBy(() -> parser.parse(expressionString)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateIllegalExpressionData() {
        return Stream.of(
                Arguments.of(generateOperatorContainer(List.of(":", ",")), ",1,2:3"),
                Arguments.of(generateOperatorContainer(List.of(":", ",")), "1,2:3,"),
                Arguments.of(generateOperatorContainer(List.of(":", ",")), "1,2::3,"),
                Arguments.of(generateOperatorContainer(List.of(":", ",", "aa")), ",1,2:aa3")
        );
    }

    @ParameterizedTest
    @DisplayName("올바른 계산식 parse시 IllegalArgumentException을 던지지 않는지 확인")
    @MethodSource("generateLegalExpressionData")
    void testParseNotThrowIllegalArgumentException(OperatorContainer operatorContainer, String expressionString) {
        ExpressionParser parser = new ExpressionParser(operatorContainer);

        assertThatNoException().isThrownBy(() -> parser.parse(expressionString));
    }

    static Stream<Arguments> generateLegalExpressionData() {
        return Stream.of(
                Arguments.of(generateOperatorContainer(List.of(":", ",")), "1,2:3"),
                Arguments.of(generateOperatorContainer(List.of(":", ",")), "1,2:3"),
                Arguments.of(generateOperatorContainer(List.of(":", ",", "aa")), "1,2aa3"),
                Arguments.of(generateOperatorContainer(List.of(":", ",", "aa")), "1"),
                Arguments.of(generateOperatorContainer(List.of(":", ",", "aa")), ""),
                Arguments.of(generateOperatorContainer(List.of(":", ",", "aa")), "")
        );
    }

    @Test
    @DisplayName("빈 문자열은 0값의 operand만을 가지는 expression으로 parse하는지 확인")
    void testParseEmptyString() {
        OperatorContainer operatorContainer = generateOperatorContainer(List.of("DUMMY"));
        ExpressionParser parser = new ExpressionParser(operatorContainer);
        Expression expected = new Expression(new CustomDeque<>(Collections.EMPTY_LIST), new CustomDeque<>(List.of(Operand.of(0))));

        Expression actual =  parser.parse(EMPTY_STRING);

        assertThat(actual).isEqualTo(expected);
    }

    private static OperatorContainer generateOperatorContainer(List<String> separatorString) {
        List<Operator> operators = separatorString.stream()
                .map(Separator::of)
                .map(separator -> new Operator(separator, DUMMY_OPERATION))
                .collect(Collectors.toList());
        return new OperatorContainer(operators);
    }
}