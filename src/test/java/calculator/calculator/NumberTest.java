package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    public void 빈문자는_0으로취급(String value) {
        assertThat(Number.from(value)).isEqualTo(new Number(0));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,4", "-1,4"}, delimiter = ',')
    public void 숫자의_합(int first, int second) {
        Number operand1 = new Number(first);
        Number operand2 = new Number(second);
        assertThat(operand1.sum(operand2)).isEqualTo(new Number(first + second));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, -1})
    public void 빈문자와의_합(int value) {
        Number operand1 = Number.from("");
        Number operand2 = new Number(value);
        assertThat(operand1.sum(operand2)).isEqualTo(new Number(value));
    }

    @Test
    public void 숫자가_아닌_문자로_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.from("a"));
    }
}
