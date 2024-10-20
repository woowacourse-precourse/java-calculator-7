package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    void getCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.getCustomDelimiter("//;\\n")).isEqualTo(";");
        assertThat(calculator.getCustomDelimiter("//.\\n")).isEqualTo(".");
        assertThat(calculator.getCustomDelimiter("//\\\\n")).isEqualTo("\\");
        assertThat(calculator.getCustomDelimiter("///\\n")).isEqualTo("/");

        assertThatThrownBy(() -> calculator.getCustomDelimiter("//1\\n"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(calculator.getCustomDelimiter("//..\\n")).isEqualTo(null);
        assertThat(calculator.getCustomDelimiter("//\\n")).isEqualTo(null);
        assertThat(calculator.getCustomDelimiter("1,2,3,4")).isEqualTo(null);
    }
}