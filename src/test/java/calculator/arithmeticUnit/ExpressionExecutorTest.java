package calculator.arithmeticUnit;

import calculator.Expression;
import calculator.OperatorEnum;
import calculator.OperatorMap;
import calculator.Separator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionExecutorTest {
    private static final Separator COLON = new Separator(":");
    private static final Separator COMMA = new Separator(",");
    private static final Separator CUSTOM = new Separator("custom");
    private final OperatorMap operatorMap = OperatorMap.getInstance();

    ExpressionExecutorTest() {
        operatorMap.registerSeparatorToOperator(COLON, OperatorEnum.PLUS);
        operatorMap.registerSeparatorToOperator(COMMA, OperatorEnum.PLUS);
        operatorMap.registerSeparatorToOperator(CUSTOM, OperatorEnum.PLUS);
    }

    @Test
    @DisplayName("일반적인 Expression을 올바르게 계산하는지 확인")
    void testCalculateGeneralExpression() {
        Expression expression = generateExpressionFrom(List.of(COLON,COMMA,CUSTOM), List.of(1,1,1,1));
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);
        int expectedResult = 4;

        int actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("비어있는 Expression을 0으로 계산하는지 확인")
    void testCalculateEmptyExpression() {
        Expression expression = generateExpressionFrom(List.of(), List.of());
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);
        int expectedResult = 0;

        int actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("양수 하나만 있는 Expression을 양수 그대로 계산하는지 확인")
    void testCalculateOnlyOneOperandExpression() {
        int onlyOperand = 4;
        Expression expression = generateExpressionFrom(List.of(), List.of(onlyOperand));
        ExpressionExecutor executor = new ExpressionExecutor(operatorMap);

        int actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(onlyOperand);
    }

    private static Expression generateExpressionFrom(List<Separator> separators, List<Integer> operands) {
        return new Expression(new ArrayDeque<>(separators), new ArrayDeque<>(operands));
    }
}