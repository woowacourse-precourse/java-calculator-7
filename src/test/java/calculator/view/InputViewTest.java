package calculator.view;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void 숫자가_없으면_입력에_실패한다() {
        String input = "/,/,/";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputView.inputNumbers());
    }
}
