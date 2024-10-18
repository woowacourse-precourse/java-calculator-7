package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 기본_구분자_계산() {
        assertEquals(new BigInteger("13"), calculator.sumFromString("1:2,10"));
    }

    @Test
    void 커스텀_구분자_계산() {
        assertEquals(new BigInteger("13"), calculator.sumFromString("//;\\n1;2,10"));
        assertEquals(new BigInteger("13"), calculator.sumFromString("//;.!\\n1;.!2;.!10"));
    }

    @Test
    void 빈_문자열_계산() {
        assertEquals(new BigInteger("0"), calculator.sumFromString(""));
    }

    @Test
    void 단일_숫자_계산() {
        assertEquals(new BigInteger("1"), calculator.sumFromString("1"));
    }

    @Test
    void 큰_숫자_계산() {
        assertEquals(
                new BigInteger("10000000000000000000"),
                calculator.sumFromString("9999999999999999999,1"));
    }
}
