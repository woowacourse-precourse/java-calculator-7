package calculator.delimiter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterReaderTest {
    DelimiterReader delimiterReader;

    @BeforeEach
    void beforeEach() {
        delimiterReader = new DelimiterReader();
    }

    @Test
    @DisplayName("구분자를 가져올 수 있어야 함")
    void test1() {
        String testLine = "//;\\n1;2;3";
        assertThat(delimiterReader.readDelimiter(testLine)).isEqualTo(";");
    }

    @Test
    @DisplayName("잘못된 prefix 구분자가 들어온다면 예외를 발생")
    void test2() {
        String testLine = "/;\\n1;2;3";
        assertThrows(IllegalArgumentException.class, () -> delimiterReader.readDelimiter(testLine));
    }

    @Test
    @DisplayName("잘못된 suffix 구분자가 들어온다면 예외를 발생")
    void test3() {
        String testLine = "//;\\a1;2;3";
        assertThrows(IllegalArgumentException.class, () -> delimiterReader.readDelimiter(testLine));
    }

}