package calculator.expression;

import calculator.arithmeticUnit.PlusOperation;
import calculator.operator.Operand;
import calculator.operator.OperatorMap;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionExecutorTest {
    private static final Separator COLON = new Separator(":");
    private static final Separator COMMA = new Separator(",");
    private static final Separator CUSTOM = new Separator("custom");
    private final OperatorMap operatorMap = OperatorMap.getInstance();

    ExpressionExecutorTest() {
        operatorMap.registerSeparatorToOperator(COLON, PlusOperation.getInstance());
        operatorMap.registerSeparatorToOperator(COMMA, PlusOperation.getInstance());
        operatorMap.registerSeparatorToOperator(CUSTOM, PlusOperation.getInstance());
    }

    @Test
    @DisplayName("일반적인 Expression을 올바르게 계산하는지 확인")
    void testCalculateGeneralExpression() {
        Expression expression = generateExpressionFrom(List.of(COLON, COMMA, CUSTOM), List.of(1, 1, 1, 1));
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);
        Operand expectedResult = Operand.of(4);

        Operand actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("비어있는 Expression을 0으로 계산하는지 확인")
    void testCalculateEmptyExpression() {
        Expression expression = generateExpressionFrom(List.of(), List.of());
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);
        Operand expectedResult = Operand.of(0);

        Operand actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("양수 하나만 있는 Expression을 양수 그대로 계산하는지 확인")
    void testCalculateOnlyOneOperandExpression() {
        int onlyOperandValue = 4;
        Operand expected = Operand.of(onlyOperandValue);
        Expression expression = generateExpressionFrom(List.of(), List.of(onlyOperandValue));
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);

        Operand actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expected);
    }

    private static Expression generateExpressionFrom(List<Separator> separators, List<Integer> operands) {
        CustomDeque<Separator> separatorDeque = separators.stream()
                .collect(Collectors.toCollection(CustomDeque::new));
        CustomDeque<Operand> operandDeque = operands.stream()
                .map(Operand::of)
                .collect(Collectors.toCollection(CustomDeque::new));
        return new Expression(separatorDeque, operandDeque);
    }
}