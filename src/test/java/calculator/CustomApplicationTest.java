package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class CustomApplicationTest extends NsTest {

    private String formatResult(long result) {
        return String.format("결과 : %d", result);
    }

    @Test
    void simple_test_with_comma() {
        // Given
        String input = "1,2,3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void simple_test_with_colon() {
        // Given
        String input = "1:2:3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void simple_test_with_comma_colon() {
        // Given
        String input = "1,2:3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void single_custom_test() {
        // Given
        String input = "//;\\n1;2;3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void duplicated_custom_test() {
        // Given
        String input = "//;;;\\n1;2;;3;;;4";
        long result = 10L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void empty_custom_test() {
        // Given
        String input = "//\\n1,2:3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void multiple_custom_test() {
        // Given
        String input = "//abc\\n1a2b3c4";
        long result = 10L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void negative_number_test() {
        // Given
        String input = "1,-2:3";

        // When-Then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void not_number_test() {
        // Given
        String input = "1,a:3";

        // When-Then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void number_overflow_test() {
        // Given
        BigInteger overflowValue = new BigInteger(String.valueOf(Long.MAX_VALUE)).add(BigInteger.ONE);
        String input = String.format("1,%s:3", overflowValue.toString());

        // When-Then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(NumberFormatException.class);
        });
    }

    @Test
    void sum_overflow_test() {
        // Given
        String input = String.format("1,%d:3", Long.MAX_VALUE);

        // When-Then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(NumberFormatException.class);
        });
    }

    @Test
    void long_max_test() {
        // Given
        String input = String.format("%d,1", Long.MAX_VALUE - 1);
        long result = Long.MAX_VALUE;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void empty_args_test() {
        // Given
        String input = "";
        long result = 0L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void invalid_custom_test() {
        // Given
        String input = "//;\\p1,2;3";

        // When-Then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void duplicated_custom_end_test() {
        // Given
        String input = "//\\n\\n1\\2n3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void regex_escape_test() {
        // Given
        String input = "//^+-\\n1^2-3+4";
        long result = 10L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void unicode_test() {
        // Given
        String input = "//ㄱ\\n1ㄱ2:3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Test
    void emoji_test() {
        // Given
        String input = "//😀\\n1😀2:3";
        long result = 6L;

        // When-Then
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(formatResult(result));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}