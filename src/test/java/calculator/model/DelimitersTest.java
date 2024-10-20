package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimitersTest {
    @Test
    @DisplayName("커스텀 구분자를 추출할 수 있다.")
    void addCustomDelimiter() {
        String input = "//a\\n1a2a3";
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiter(input);
        Assertions.assertThat(delimiters.toConcatenatedString()).isEqualTo(",:a");
    }
}