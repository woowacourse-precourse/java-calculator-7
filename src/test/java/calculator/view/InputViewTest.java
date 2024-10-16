package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    InputStream createStringInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("Console.readLine() 테스트")
    public void inputTest() {
        // given
        System.setIn(createStringInput("1:2,3"));

        // when, then
        assertThat(inputView.inputString()).isEqualTo("1:2,3");
    }
}
