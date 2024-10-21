package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpressionTest {
    private Expression expression;

    @BeforeEach
    void beforeEach() {
        expression = new Expression("12,23");
    }

    @Test
    void 덧셈_계산() {
        expression.processRawExpression(List.of(':', ','));
        assertEquals(expression.getListSum(), new BigInteger("35"));

    }

    @Test
    void 큰값_계산() {
        Expression bigExpression = new Expression(Long.MAX_VALUE + "0"); //Long보다 큰 단위
        bigExpression.processRawExpression(List.of(':', ','));
        assertEquals(bigExpression.getListSum(), new BigInteger("92233720368547758070"));

    }
}