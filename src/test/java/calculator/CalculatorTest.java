package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    private String formatResult(long result) {
        return String.format("결과 : %d", result);
    }

    @Test
    void simple_test_with_comma() {
        String args = "1,2,3";
        long result = 6L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void simple_test_with_colon() {
        String args = "1:2:3";
        long result = 6L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void simple_test_with_comma_colon() {
        String args = "1,2:3";
        long result = 6L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void single_custom_test() {
        String args = "//;\\n1;2;3";
        long result = 6L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void duplicated_custom_test() {
        String args = "//;;;\\n1;2;;3;;;4";
        long result = 10L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void empty_custom_test() {
        String args = "//\\n1,2:3";
        long result = 6L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void multiple_custom_test() {
        String args = "//abc\\n1a2b3c4";
        long result = 10L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void negative_number_test() {
        String args = "1,-2:3";

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("args"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void not_number_test() {
        String args = "1,a:3";

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("args"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void number_overflow_test() {
        BigInteger overflowValue = new BigInteger(String.valueOf(Long.MAX_VALUE)).add(BigInteger.ONE);
        String args = String.format("1,%s:3", overflowValue.toString());

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(args))
                    .isInstanceOf(NumberFormatException.class);
        });
    }

    @Test
    void sum_overflow_test() {
        String args = String.format("1,%d:3", Long.MAX_VALUE);

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(args))
                    .isInstanceOf(NumberFormatException.class);
        });
    }

    @Test
    void long_max_test() {
        String args = String.format("%d,1", Long.MAX_VALUE - 1);
        long result = Long.MAX_VALUE;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void empty_args_test() {
        String args = "";
        long result = 0L;

        assertSimpleTest(() -> {
            run(args);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}