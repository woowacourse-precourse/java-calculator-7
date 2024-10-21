package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExpressionParserTest {

    @Test
    public void 문자열_파싱_테스트() {
        List<BigInteger> integerListFromSeparator = ExpressionParser.getIntegerListFromSeparator("1,2",
                List.of(':', ','));
        assertEquals(List.of(new BigInteger("1"), new BigInteger("2")), integerListFromSeparator);
    }

    @Test
    public void 문자열_파싱_예외() {
        assertThatThrownBy(() -> ExpressionParser.getIntegerListFromSeparator("1.2", List.of(':', ',')))
                .isInstanceOf(IllegalArgumentException.class);
    }

}