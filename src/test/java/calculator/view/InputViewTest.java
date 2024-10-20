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

class InputViewTest {
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
    @DisplayName("[기본 구분자] 정상 계산 문자열 입력")
    @ValueSource(strings = {"1,2,3", "1,2:3", "1:2:3"})
    void 기본_구분자만_사용하는_정상_입력(String userInput) {
        // given
        System.setIn(readUserInput(userInput));
        // when
        String readInputString = inputView.readInputString();
        // then
        Assertions.assertThat(readInputString).isEqualTo(userInput);
    }

    @ParameterizedTest
    @DisplayName("[커스텀 구분자] 정상 계산 문자열 입력")
    @ValueSource(strings = {"//;\\n1,2;3", "//;\\n1;2;3;3;4"})
    void 커스텀_구분자_사용하는_정상_입력(String userInput) {
        // given
        System.setIn(readUserInput(userInput));
        // when
        String readInputString = inputView.readInputString();
        // then
        Assertions.assertThat(readInputString).isEqualTo(userInput);
    }

    @ParameterizedTest
    @DisplayName("[정상 구분자] 아무 값도 입력하지 않은 경우")
    @ValueSource(strings = {"\n"})
    void 아무_값도_입력하지_않은_경우(String userInput) {
        // given
        System.setIn(readUserInput(userInput));
        // when
        String readInputString = inputView.readInputString();
        // then
        Assertions.assertThat(readInputString).isEmpty();
    }

    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }

}