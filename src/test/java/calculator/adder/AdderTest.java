package calculator.adder;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class AdderTest {

    @Test
    void addInput_defaultInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "1,2:3";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(new BigInteger("6"));
        });
    }

    @Test
    void addInput_emptyInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(BigInteger.ZERO);
        });
    }

    @Test
    void addInput_customDelimiterInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "//;\\n1;2;3";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(new BigInteger("6"));
        });
    }

    @Test
    void addInput_customDelimiterInput2() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "//[\\n1[2[3";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(new BigInteger("6"));
        });
    }

    @Test
    void addInput_onlyCustomDelimiterInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "//;\\n";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(BigInteger.ZERO);
        });
    }

    @Test
    void addInput_BigNum() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "10000000000000000000,10000000000000000000";

            BigInteger result = adder.addInput(input);
            assertThat(result).isEqualTo(new BigInteger("20000000000000000000"));
        });
    }

    @Test
    void addInput_negativeInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "-1,2:3";

            assertThatThrownBy(() -> adder.addInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void addInput_invalidInput() {
        assertSimpleTest(() -> {
            Adder adder = new Adder();
            String input = "1,s:3";

            assertThatThrownBy(() -> adder.addInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}