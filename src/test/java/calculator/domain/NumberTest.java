package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {
    @ParameterizedTest
    @CsvSource(value = {"'1234 '", "' 1234'", "12 34", "''", "123a"})
    void 숫자가_아닌_경우_예외처리(String value) {
        assertThatThrownBy(() -> new Number(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_양수가_아닌_경우_예외처리() {
        assertThatThrownBy(() -> new Number("-1")).isInstanceOf(IllegalArgumentException.class);
    }
}