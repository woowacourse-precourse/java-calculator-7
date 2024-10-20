package calculator;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorModelTest {

    private final CalculatorModel model = new CalculatorModel();

    @Test
    void testBasicAddition() {
        Set<Character> delimiters = Set.of(',', ':');
        String input = "1,2:3";
        int result = model.add(input, delimiters);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testEmptyString() {
        Set<Character> delimiters = Set.of(',', ':');
        String input = "";
        int result = model.add(input, delimiters);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testNegativeNumber() {
        Set<Character> delimiters = Set.of(',', ':');
        String input = "1,-2,3";

        assertThatThrownBy(() -> model.add(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Negative numbers are not allowed");
    }
}
