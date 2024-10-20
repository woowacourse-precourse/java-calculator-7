package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void calculateTest() {
        List<String> longNumber = List.of("123", "456");
        List<String> bigIntegerNumber = List.of("9223372036854775808", "9223372036854775809");

        BigInteger result1 = StringCalculator.calculate(longNumber);
        BigInteger result2 = StringCalculator.calculate(bigIntegerNumber);

        assertThat(result1).isEqualTo("579");
        assertThat(result2).isEqualTo("18446744073709551617");
    }
}
