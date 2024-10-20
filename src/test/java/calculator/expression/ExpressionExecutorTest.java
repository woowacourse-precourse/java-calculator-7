package calculator.expression;

import calculator.arithmeticUnit.PlusOperation;
import calculator.operator.Operand;
import calculator.operator.Operator;
import calculator.operator.OperatorContainer;
import calculator.operator.Separator;
import calculator.utils.CustomDeque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionExecutorTest {
    private static final Separator COLON = Separator.of(":");
    private static final Separator COMMA = Separator.of(",");
    private static final Separator CUSTOM = Separator.of("custom");
    private final OperatorContainer operatorContainer;

    ExpressionExecutorTest() {
        Operator colonOperator = new Operator(COLON, PlusOperation.getInstance());
        Operator seperatorOperator = new Operator(COMMA, PlusOperation.getInstance());
        Operator customOperator = new Operator(CUSTOM, PlusOperation.getInstance());
        this.operatorContainer = new OperatorContainer(List.of(colonOperator, seperatorOperator, customOperator));
    }


    @Test
    @DisplayName("일반적인 Expression을 올바르게 계산하는지 확인")
    void testCalculateGeneralExpression() {
        Expression expression = generateExpressionFrom(List.of(COLON, COMMA, CUSTOM), List.of(1, 1, 1, 1));
        ExpressionExecutor executor = new ExpressionExecutor(operatorContainer);
        Operand expectedResult = Operand.of(4);

        Operand actual = executor.calculate(expression);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("양수 하나만 있는 Expression을 양수 그대로 계산하는지 확인")
    void testCalculateOnlyOneOperandExpression() {
        int onlyOperandValue = 4;
        Operand expected = Operand.of(onlyOperandValue);
        Expression expression = generateExpressionFrom(List.of(), List.of(onlyOperandValue));
        ExpressionExecutor executor = new ExpressionExecutor(operatorContainer);

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