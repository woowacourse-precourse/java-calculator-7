package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {
    private InputView inputView;
    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @DisplayName("문자열 입력 - 기본 문자열(정상)")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3"})
    void test_기본문자열_입력(String userInput) {
        // given
        System.setIn(readUserInput(userInput));
        // when
        String readInputString = inputView.InputString();
        // then
        Assertions.assertThat(readInputString).isEqualTo(userInput);
    }

    @ParameterizedTest
    @DisplayName("문자열 입력 - 커스텀 문자열(정상)")
    @ValueSource(strings = {"//;\\n1,2;3", "//q\\n1q2q3"})
    void test_커스텀문자열_입력(String userInput) {
        // given
        System.setIn(readUserInput(userInput));
        // when
        String readInputString = inputView.InputString();
        // then
        Assertions.assertThat(readInputString).isEqualTo(userInput);
    }


    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
