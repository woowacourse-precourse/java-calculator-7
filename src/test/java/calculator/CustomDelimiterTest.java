package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomDelimiterTest {

    @Test
    @DisplayName("커스텀 구분자 하나 입력시 정상적으로 동작")
    void 커스텀_구분자_한개_입력() {
        String input = "//;\\n1;2;3";

        String customDelimiter = Delimiter.getCustomDelimiter(input);

        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 두개 입력될 경우 IllegalArgumentException 발생")
    void 커스텀_구분자_두개_입력() {
        String input = "//;;\\n";

        assertThrows(IllegalArgumentException.class, () -> {
            String customDelimiter = Delimiter.getCustomDelimiter(input);
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 특수 문자 입력시 커스텀 구분자 인식")
    void 커스텀_구분자로_특수문자_입력() {
        String input = "//.\\n1.2.3";

        String customDelimiter = Delimiter.getCustomDelimiter(input);

        assertThat(customDelimiter).isEqualTo(".");
    }

    @Test
    @DisplayName("커스텀 구분자로 특수 문자 두개 입력시 IllegalArgumentException 발생")
    void 커스텀_구분자로_특수문자_두개_입력() {
        String input = "//..\\n1.2.3";

        assertThrows(IllegalArgumentException.class, () -> {
            String customDelimiter = Delimiter.getCustomDelimiter(input);
        });
    }
}
