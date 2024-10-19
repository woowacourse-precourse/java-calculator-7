package calculator.view;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void inputExpressionStringTest() {
        // given
        String expectedInput = "1,2,3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        // when
        String result = inputView.inputExpressionString();

        // then
        Assertions.assertThat(result).isEqualTo("1,2,3");
    }
}