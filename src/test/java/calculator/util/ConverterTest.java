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
        String string1 = "//;\\n1;2;3"; // "//;\n1;2;3
        Assertions.assertThat(Converter.stringToNumbers(string1)).isEqualTo(List.of(1, 2, 3));

        String string2 = "// \\n1 2 3"; // "// \n1 2 3"
        Assertions.assertThat(Converter.stringToNumbers(string2)).isEqualTo(List.of(1, 2, 3));

        String string3 = "//\\\\n1\\2\\3"; // "//\\n1\2\3"
        Assertions.assertThat(Converter.stringToNumbers(string3)).isEqualTo(List.of(1, 2, 3));
    }
}