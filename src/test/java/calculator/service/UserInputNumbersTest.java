package calculator.service;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserInputNumbersTest {

    @ParameterizedTest
    @MethodSource("적합데이터")
    void 입력파싱(final String inputMessage, final String result) {
        final UserInputNumbers inputNumbers = UserInputNumbers.of(inputMessage);
        Assertions.assertThat(inputNumbers.toString())
                .isEqualTo(result);
    }

    static Stream<Arguments> 적합데이터() {
        return Stream.of(
                Arguments.of("123123,123123,123123", "123123,123123,123123"),
                Arguments.of("//1234222\\n1", "1"),
                Arguments.of("//1234222\\n", ""),
                Arguments.of("//1234222\\n1231", "1231")
        );
    }
}