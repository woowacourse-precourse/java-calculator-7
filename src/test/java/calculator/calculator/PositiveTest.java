package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Positive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    public void 빈문자는_0으로취급(String value) {
        assertThat(Positive.from(value)).isEqualTo(new Positive(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    public void 음수생성(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.from(value));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,4", "1,4"}, delimiter = ',')
    public void 숫자의_합(int first, int second) {
        Positive operand1 = new Positive(first);
        Positive operand2 = new Positive(second);
        assertThat(operand1.sum(operand2)).isEqualTo(new Positive(first + second));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5})
    public void 빈문자와의_합(int value) {
        Positive operand1 = Positive.from("");
        Positive operand2 = new Positive(value);
        assertThat(operand1.sum(operand2)).isEqualTo(new Positive(value));
    }

    @Test
    public void 숫자가_아닌_문자로_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.from("a"));
    }
}
