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

    @Test
    void removeHeaderFromInput() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.removeHeaderFromInput("//;\\n")).isEqualTo("");
        assertThat(calculator.removeHeaderFromInput("//;\\n1,2,3:4;5")).isEqualTo("1,2,3:4;5");
        assertThat(calculator.removeHeaderFromInput("//;\\n//;\\n123")).isEqualTo("//;\\n123");
        assertThat(calculator.removeHeaderFromInput("1:2,3")).isEqualTo("1:2,3");
        assertThat(calculator.removeHeaderFromInput("//;\\")).isEqualTo("//;\\");
        assertThat(calculator.removeHeaderFromInput("")).isEqualTo("");
        assertThat(calculator.removeHeaderFromInput("1//;\\n")).isEqualTo("1//;\\n");
    }
}