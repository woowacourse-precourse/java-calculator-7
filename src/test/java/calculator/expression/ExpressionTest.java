package calculator.expression;

import calculator.operator.Operand;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    @ParameterizedTest
    @DisplayName("피연산자 갯수가 sperator 갯수보다 1 크지 않을 때 IllegalArgumentException발생 확인")
    @MethodSource("generateIllegalExpressionData")
    void testThrowIllegalArgumentException(CustomDeque<Separator> separatorDeque, CustomDeque<Operand> operandDeque) {
        assertThatThrownBy(() -> new Expression(separatorDeque, operandDeque)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateIllegalExpressionData() {
        return Stream.of(
                Arguments.of(new CustomDeque<>(List.of(Separator.of(";"))), new CustomDeque<>(List.of(Operand.of(1)))),
                Arguments.of(new CustomDeque<>(List.of(Separator.of(";"))), new CustomDeque<>(List.of(Operand.of(1), Operand.of(2), Operand.of(3)))),
                Arguments.of(new CustomDeque<>(List.of(Separator.of(";"), Separator.of(";"))), new CustomDeque<>(List.of(Operand.of(1))))
        );
    }

    @Test
    @DisplayName("가장 앞의 피연산자를 반환하는지 확인")
    void testPeekFirstOperand() {
        Operand expected = Operand.of(1);
        Expression expression = new Expression(new CustomDeque<>(Collections.EMPTY_LIST), new CustomDeque<>(List.of(expected)));

        Operand firstOperand = expression.peekFirstOperand();

        assertThat(firstOperand).isEqualTo(expected);
    }

    @Test
    @DisplayName("두번째 피연산자를 반환하는지 확인")
    void testPeekSecondOperand() {
        Operand firstOperand = Operand.of(1);
        Operand secondOperand = Operand.of(2);
        CustomDeque<Separator> dummySeparatorDeque = new CustomDeque<>(List.of(Separator.of("")));
        CustomDeque<Operand> operandDeque = new CustomDeque<>(List.of(firstOperand, secondOperand));
        Expression expression = new Expression(dummySeparatorDeque, operandDeque);
;
        Operand actual = expression.peekSecondOperand();

        assertThat(actual).isEqualTo(secondOperand);
    }

    @Test
    @DisplayName("피연산자가 두개 이하일 때 peekSecondOperand시 NoSuchElementException 발생 확인")
    void testPeekFirstTwoOperandsThrowNoSuchElementException() {
        Expression expression = generateExpression(Collections.emptyList(), List.of(1));

        assertThatThrownBy(expression::peekSecondOperand).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Separator가 더이상 없을떄 peekSeparator 시 NoSuchElementException 발생 확인")
    void peekSeparator() {
        Expression expression = generateExpression(Collections.emptyList(), List.of(1));

        assertThatThrownBy(expression::peekFirstSeparator).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("앞 두개의 operand와 하나의 separator를 제거하고 주어진 operand를 가장 앞으로 넣어 Expression을 생성하는지 확인")
    void updateFirstOperationResult() {
        String firstSeparator = "firstSeparator";
        String secondSeparator = "secondSeparator";
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;
        Operand firstOperationResult = Operand.of(7);
        Expression expression = generateExpression(List.of(firstSeparator, secondSeparator), List.of(firstValue, secondValue, thirdValue));
        Expression expected = generateExpression(List.of(secondSeparator), List.of(firstOperationResult.getValue(), thirdValue));

        Expression afterOperation = expression.updateFirstOperationResult(firstOperationResult);

        assertThat(afterOperation).isEqualTo(expected);
    }

    @Test
    @DisplayName("speartor와 operand의 구성이 같다면 같은 객체로 판단하는지 확인")
    void testEquals() {
        Expression expression = generateExpression(List.of(";"), List.of(1, 2));
        Expression anotherExpression = generateExpression(List.of(";"), List.of(1, 2));

        assertThat(expression).isEqualTo(anotherExpression);
    }

    @Test
    @DisplayName("speartor와 피연산자의 구성이 같다면 같은 hashcode를 반환하는지 확인")
    void testHashCode() {
        Expression expression = generateExpression(List.of(";"), List.of(1, 2));
        Expression anotherExpression = generateExpression(List.of(";"), List.of(1, 2));

        assertThat(expression).hasSameHashCodeAs(anotherExpression);
    }

    private static Expression generateExpression(List<String> separatorString, List<Integer> operands) {
        CustomDeque<Separator> separatorDeque = separatorString.stream()
                .map(Separator::of)
                .collect(Collectors.toCollection(CustomDeque::new));
        CustomDeque<Operand> operandDeque = operands.stream()
                .map(Operand::of)
                .collect(Collectors.toCollection(CustomDeque::new));
        return new Expression(separatorDeque, operandDeque);
    }
}