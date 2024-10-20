package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class CalculatorViewTest {

    @Test
    void 사용자로부터_데이터를_읽어올_수_있다() {
        // given
        CalculatorView calculatorView = new CalculatorView();

        // when
        System.setIn(new ByteArrayInputStream("2 + 3".getBytes()));
        String result = calculatorView.read();

        // then
        assertThat(result).isEqualTo("2 + 3");
    }

}