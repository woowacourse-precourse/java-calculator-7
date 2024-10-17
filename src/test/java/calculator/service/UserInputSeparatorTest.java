package calculator.service;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserInputSeparatorTest {

    @ParameterizedTest
    @MethodSource("정상커스텀구분자입력")
    void 구분자파싱(final String inputMessage, final String separator) {
        final UserInputSeparator userInputSeparator = UserInputSeparator.of(inputMessage);
        Assertions.assertThat(userInputSeparator.getSeparator())
                .isEqualTo(separator);
    }

    @ParameterizedTest
    @MethodSource("숫자만입력")
    void 커스텀구분자없음(final String inputMessage) {
        final UserInputSeparator userInputSeparator = UserInputSeparator.of(inputMessage);
        Assertions.assertThat(userInputSeparator)
                .isEqualTo(null);
    }

    static Stream<Arguments> 정상커스텀구분자입력() {
        return Stream.of(
                Arguments.of("//1234222\\n1", "1234222"),
                Arguments.of("//-\\n1", "-"),
                Arguments.of("//\\n1", "")
        );
    }

    static Stream<Arguments> 숫자만입력() {
        return Stream.of(
                Arguments.of("123123"),
                Arguments.of("1,23,4,125,21.3,123,2"),
                Arguments.of(":';qw;ew;")
        );
    }
}