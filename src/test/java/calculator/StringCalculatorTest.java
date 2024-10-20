package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void splitStringByDelimiters() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.splitStringByDelimiters("1,2;3", List.of(";", ","))).containsExactly("1", "2", "3");
        assertThat(calculator.splitStringByDelimiters("1,2:3", List.of(";", ","))).containsExactly("1", "2:3");
        assertThat(calculator.splitStringByDelimiters("", List.of(";", ","))).containsExactly();
        assertThat(calculator.splitStringByDelimiters("2;;3", List.of(";", ","))).containsExactly("2", "", "3");
        assertThat(calculator.splitStringByDelimiters("133221333123111", List.of(";", ","))).containsExactly("133221333123111");
        assertThat(calculator.splitStringByDelimiters("1\\2n3", List.of("\\", "n"))).containsExactly("1", "2", "3");
    }

    @Test
    void calculateSum() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.calculateSum("1,2,3,4", List.of(";", ","))).isEqualTo(10);
        assertThat(calculator.calculateSum("", List.of(";", ","))).isEqualTo(0);
        assertThat(calculator.calculateSum("1,2:3;4", List.of(":", ",", ";"))).isEqualTo(10);

        assertThatThrownBy(() -> calculator.calculateSum("1,1.0", List.of(":", ",", ";")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculateSum("1,-2", List.of(":", ",", ";")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculateSum("1,asdf", List.of(":", ",", ";")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculateSum("//;\\n\"//;\\\\n1,2,3", List.of(":", ",", ";")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculateSum("//;p\\n1,2,3", List.of(":", ",", ";")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}