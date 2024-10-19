package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    @MethodSource(value = "provideInputAndExpected")
    @ParameterizedTest(name = "입력값: \"{0}\", 기대값: \"{1}\"")
    @DisplayName("정상 입력을 받으면 해당 줄을 읽어온다")
    void 정상_입력(String input, String expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();

        String read = inputView.read();

        assertThat(read).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputAndExpected() {
        return Stream.of(
                Arguments.of(createInputWithLineSeparator(""), ""),
                Arguments.of(createInputWithLineSeparator("1,2"), "1,2"),
                Arguments.of(createInputWithLineSeparator("1,2;3"), "1,2;3")
        );
    }

    private static String createInputWithLineSeparator(String input) {
        return input.concat(System.lineSeparator());
    }

}
