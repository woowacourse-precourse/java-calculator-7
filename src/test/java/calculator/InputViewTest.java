package calculator;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class InputViewTest extends NsTest {
    @Test
    void 입력값_받기() {
        String input = "1,2,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String result = inputView.getString();

        assertThat(result).isEqualTo("1,2,3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}