package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputStream originalIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 사용자_입력_읽기() {
        String mockInput = "1,2:3";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        var runner = new InputHandler();

        String result = runner.readInput();

        assertThat(result).isEqualTo("1,2:3");
    }

    @Test
    void 커스텀_구분자_추출() {
        String mockInput = "//a\\n1,2:3";

        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        var runner = new InputHandler();

        String userInput = runner.readInput();

        char result = runner.extractCustomDelimiter(userInput);
        assertThat(result).isEqualTo('a');
    }
}
