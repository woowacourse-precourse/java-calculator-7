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
                Arguments.of(new CustomDeque<>(List.of(new Separator(";"))), new CustomDeque<>(List.of(Operand.of(1)))),
                Arguments.of(new CustomDeque<>(List.of(new Separator(";"))), new CustomDeque<>(List.of(Operand.of(1), Operand.of(2), Operand.of(3)))),
                Arguments.of(new CustomDeque<>(List.of(new Separator(";"), new Separator(";"))), new CustomDeque<>(List.of(Operand.of(1))))
        );
    }

    @Test
    @DisplayName("처음 두개의 피연산자를 반환하는지 확인")
    void testPeekFirstTwoOperands() {
        int firstOperandValue = 1;
        int secondOperandValue = 2;
        Expression expression = generateExpression(List.of(";"), List.of(firstOperandValue, secondOperandValue));

        List<Operand> twoOperands = expression.peekFirstTwoOperands();
        Operand firstOperand = twoOperands.get(0);
        Operand secondOperand = twoOperands.get(1);

        assertThat(firstOperand).isEqualTo(Operand.of(firstOperandValue));
        assertThat(secondOperand).isEqualTo(Operand.of(secondOperandValue));
    }

    @Test
    @DisplayName("피연산자가 두개 이하일 때 NoSuchElementException 발생 확인")
    void testPeekFirstTwoOperandsThrowNoSuchElementException() {
        Expression expression = generateExpression(Collections.emptyList(), List.of(1));

        assertThatThrownBy(expression::peekFirstTwoOperands).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Expression이 비어있을때 피연산자 peek시 NoSuchElementException 발생 확인")
    void testPeekFirstOperandThrowNoSuchElementException() {
        Expression expression = generateExpression(Collections.emptyList(), Collections.emptyList());

        assertThatThrownBy(expression::peekFirstOperand).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Expression이 비어있을때 구분자 peek시 NoSuchElementException 발생 확인")
    void peekFirstSeparator() {
        Expression expression = generateExpression(Collections.emptyList(), Collections.emptyList());

        assertThatThrownBy(expression::peekFirstSeparator).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("맨 앞의 연산 결과를 주면 다음 연산을 위한 Expression을 생성하는지 확인")
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
    @DisplayName("speartor와 피연산자의 구성이 같다면 같은 객체로 판단하는지 확인")
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
                .map(Separator::new)
                .collect(Collectors.toCollection(CustomDeque::new));
        CustomDeque<Operand> operandDeque = operands.stream()
                .map(value -> Operand.of(value))
                .collect(Collectors.toCollection(CustomDeque::new));
        return new Expression(separatorDeque, operandDeque);
    }
}