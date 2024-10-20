package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import calculator.model.Number;
import camp.nextstep.edu.missionutils.test.NsTest;

class NumberTest extends NsTest {

    @Test
    void 문자를_Number로_변환하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Number.from("one"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 음수를_Number로_변환하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Number.from("-1"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 소수_Number로_변환하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Number.from("1.231"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 양수를_Number로_변환한다() {
        assertSimpleTest(() -> {
            Number number = Number.from("100000");
            BigInteger expected = new BigInteger("100000");
            assertThat(number.number()).isEqualTo(expected);
        });
    }

    @Test
    void 매우_큰_양수를_Number로_변환한다() {
        assertSimpleTest(() -> {
            Number number = Number.from("100000000000000000000000");
            BigInteger expected = new BigInteger("100000000000000000000000");
            assertThat(number.number()).isEqualTo(expected);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
