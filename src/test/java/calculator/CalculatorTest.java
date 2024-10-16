package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("입력 값을 반환한다.")
    void 입력_값_반환() {
        // Given
        Calculator calculator = new Calculator();
        String input = "입력값";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        String result = calculator.getInput();

        // Then
        assertThat(result).isEqualTo(input);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("null 입력 시 예외를 발생시킨다.")
    void null_입력_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = null;

        // When & Then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null입니다.");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다.")
    void 빈_문자열_입력_시_0_반환() {
        // Given
        Calculator calculator = new Calculator();
        String input = "";

        // When
        int result = calculator.add(input);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
