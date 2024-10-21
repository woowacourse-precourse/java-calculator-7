package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigIntegerTest {

    @Test
    @DisplayName("0에 부호가 있어도 BigInteger는 양수/음수로 판단하지 않음")
    void 부호가_있는_0_받으면() {
        BigInteger negativeZero = new BigInteger("-0");
        BigInteger positiveZero = new BigInteger("+0");

        assertThat(negativeZero).isEqualTo(BigInteger.ZERO);
        assertThat(negativeZero.signum()).isEqualTo(0);

        assertThat(positiveZero).isEqualTo(BigInteger.ZERO);
        assertThat(positiveZero.signum()).isEqualTo(0);
    }

    @Test
    void 양수와_음수의_부호() {
        BigInteger negativeNumber = new BigInteger("-100");
        BigInteger positiveNumber = new BigInteger("100");

        assertThat(negativeNumber.signum()).isEqualTo(-1);
        assertThat(positiveNumber.signum()).isEqualTo(1);
    }

}
