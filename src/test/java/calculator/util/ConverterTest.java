package calculator.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    void noCustomDelimiterTest() {
        String string = "1,2:3:4,5";
        Assertions.assertThat(Converter.stringToNumbers(string)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @Test
    void customDelimiterTest() {
        String string = "//customDelimiter\n1,2customDelimiter3,4";
        Assertions.assertThat(Converter.stringToNumbers(string)).isEqualTo(List.of(1, 2, 3, 4));
    }
}