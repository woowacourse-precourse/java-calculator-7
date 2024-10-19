package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @MethodSource(value = "provideInputAndExpected")
    @ParameterizedTest(name = "입력값: \"{0}\", 기대값: \"{1}\"")
    @DisplayName("정상 입력을 받으면 해당 줄을 읽어온다")
    void 정상_입력(String input, String expected) {
        systemIn(input);

        String read = inputView.read();

        assertThat(read).isEqualTo(expected);
    }

    @MethodSource(value = "provideWrongInput")
    @ParameterizedTest
    @DisplayName("잘못된 입력은 공백으로 이루어진 입력이다")
    void 잘못된_입력(String input) {
        systemIn(input);

        assertThatThrownBy(() -> inputView.read())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void systemIn(final String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    private static Stream<Arguments> provideInputAndExpected() {
        return Stream.of(
                Arguments.of(createInputWithLineSeparator(""), ""),
                Arguments.of(createInputWithLineSeparator("1,2"), "1,2"),
                Arguments.of(createInputWithLineSeparator("1,2;3"), "1,2;3")
        );
    }

    private static Stream<Arguments> provideWrongInput() {
        return Stream.of(
                Arguments.of(createInputWithLineSeparator(" ")),
                Arguments.of(createInputWithLineSeparator("   "))
        );
    }

    private static String createInputWithLineSeparator(String input) {
        return input.concat(System.lineSeparator());
    }

}
