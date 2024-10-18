package calculator.expression;

import calculator.operator.Separator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    @ParameterizedTest
    @DisplayName("피연산자 갯수가 sperator 갯수보다 1 크지 않을 때 IllegalArgumentException발생 확인")
    @MethodSource("generateIllegalExpressionData")
    void testThrowIllegalArgumentException(Deque<Separator> separatorDeque, Deque<Integer> operandDeque) {
        assertThatThrownBy(() -> new Expression(separatorDeque, operandDeque)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateIllegalExpressionData() {
        return Stream.of(
                Arguments.of(new ArrayDeque<>(List.of(new Separator(";"))), new ArrayDeque<>(List.of(1))),
                Arguments.of(new ArrayDeque<>(List.of(new Separator(";"))), new ArrayDeque<>(List.of(1,2,3))),
                Arguments.of(new ArrayDeque<>(List.of(new Separator(";"),new Separator(";"))), new ArrayDeque<>(List.of(1)))
                );
    }


    @Test
    @DisplayName("처음 두개의 피연산자를 반환하는지 확인")
    void testPeekFirstTwoOperands() {
        Expression expression = generateExpression(List.of(";"), List.of(1, 2));

        List<Integer> twoOperands = expression.peekFirstTwoOperands();
        int firstOperand = twoOperands.get(0);
        int secondOperand = twoOperands.get(1);

        assertThat(firstOperand).isEqualTo(1);
        assertThat(secondOperand).isEqualTo(2);
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
        int firstOperationResult = 7;
        Expression expression = generateExpression(List.of(firstSeparator, secondSeparator), List.of(firstValue, secondValue, thirdValue));
        Expression expected = generateExpression(List.of(secondSeparator), List.of(firstOperationResult, thirdValue));

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
        Deque<Separator> separatorDeque = separatorString.stream()
                .map(Separator::new)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> operandDeque = new ArrayDeque<>(operands);
        return new Expression(separatorDeque, operandDeque);
    }
}