package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("입력 메시지를 출력한다.")
    void 입력_메시지_출력() {
        // Given
        Calculator calculator = new Calculator();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // When
        calculator.displayInputMessage();

        // Then
        assertThat(outputStream.toString()).isEqualTo("덧셈할 문자열을 입력해 주세요.\n");

        // Cleanup
        System.setOut(originalOut);
    }
}
