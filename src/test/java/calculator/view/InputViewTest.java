package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    @ParameterizedTest
    @DisplayName("옳바른 형식으로 입력을 하면 입력값을 반환한다")
    @ValueSource(strings = {"1", "1,2", "1,2,3", "//a\\n1a2a3"})
    void getInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        String result = inputView.getInput();
        Console.close();

        Assertions.assertThat(result).isEqualTo(input);
    }
}