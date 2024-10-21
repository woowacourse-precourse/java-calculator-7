package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.SumCalculator;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {

    private final SumCalculator calculator = new SumCalculator();

    @Test
    @DisplayName("빈 문자열")
    public void testCalculateSumWithEmptyString() {
        BigInteger result = calculator.Sum("", ";");
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    @DisplayName("커스텀 구분자 사용")
    public void testCalculateSumWithCustomSeparator() {
        BigInteger result = calculator.Sum("1;2;3", ";");
        assertEquals(new BigInteger("6"), result);
    }

    @Test
    @DisplayName("기본 구분자 사용")
    public void testCalculateSumWithDefaultSeparators() {
        BigInteger result = calculator.Sum("1,2:3", ";");
        assertEquals(new BigInteger("6"), result);
    }

    @Test
    @DisplayName("커스텀 구분자가 띄어쓰기이고 기본 구분자와 혼합헤서 사용")
    public void testCalculateSumWithMixedSeparators() {
        BigInteger result = calculator.Sum("1,2:3 5", " ");
        assertEquals(new BigInteger("11"), result);
    }

    @Test
    @DisplayName("long형으로도 받을수없이 큰 숫자 사용")
    public void testCalculateSumWithHugeNumbers() {
        BigInteger result = calculator.Sum("10000000000000000000,20000000000000000000", ";");
        assertEquals(new BigInteger("30000000000000000000"), result);  // 1000000000 + 2000000000 = 3000000000
    }
}
