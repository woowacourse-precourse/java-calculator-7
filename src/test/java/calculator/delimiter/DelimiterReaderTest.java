package calculator.delimiter;

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
    @DisplayName("구분자를 찾을 수 없다면 디폴트 구분자를 사용함")
    void test1() {
        String testLine = "1;2;3";

        assertThat(delimiterReader.readDelimiter(testLine)).isEqualTo(Delimiter.DEFAULT_DELIMITER);
    }

    @Test
    @DisplayName("구분자를 가져올 수 있어야 함")
    void test2() {
        String testLine = "//;\\n1;2;3";

        Delimiter result = delimiterReader.readDelimiter(testLine);

        assertThat(result.getCustomDelimiter()).isEqualTo(";");
    }

    @Test
    @DisplayName("잘못된 prefix 구분자가 들어온다면 예외를 발생")
    void test3() {
        String testLine = "/;\\n1;2;3";

        assertThrows(IllegalArgumentException.class, () -> delimiterReader.readDelimiter(testLine));
    }

    @Test
    @DisplayName("잘못된 suffix 구분자가 들어온다면 예외를 발생")
    void test4() {
        String testLine = "//;\\a1;2;3";

        assertThrows(IllegalArgumentException.class, () -> delimiterReader.readDelimiter(testLine));
    }

}