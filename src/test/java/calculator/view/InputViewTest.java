package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static final String USER_INPUT = "1:2:3,4";
    InputView inputView = new InputView();

    @Test
    @DisplayName("사용자가 올바른 문자열을 입력하면 테스트는 성공한다.")
    void 올바른_문자열_입력() {
        InputStream in = new ByteArrayInputStream(USER_INPUT.getBytes());
        System.setIn(in);

        String result = inputView.readUserInput();

        assertThat(result).isEqualTo(USER_INPUT);
    }

}