package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.util.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DivisionTest {

    @ParameterizedTest
    @DisplayName("delimiter")
    @MethodSource("providedNumber")
    void delimiter(String input, List<String> answer) throws Exception {
        // given

        // when
        List<String> split = Division.split(input);

        // then
        assertThat(split).hasSize(3)
                .containsAll(answer);
    }

    private static Stream<Arguments> providedNumber() {
        return Stream.of(
                Arguments.arguments("1,2:3", List.of("1", "2", "3")),
                Arguments.arguments("1,2,3", List.of("1", "2", "3")),
                Arguments.arguments("1:2:3", List.of("1", "2", "3")),
                Arguments.arguments("//;\\n1:2;3", List.of("1", "2", "3")),
                Arguments.arguments("//q\\n1q2:3", List.of("1", "2", "3")),
                Arguments.arguments("// \\n1 2 3", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest
    @DisplayName("포맷에 맞지 않는 값을 입력하면 에러가 난다")
    @MethodSource("providedWrongFormat")
    void invalidFormat(String input) throws Exception {

        // then
        assertThatThrownBy(() -> Division.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_FORMAT);
    }

    private static Stream<Arguments> providedWrongFormat() {
        return Stream.of(
                Arguments.arguments(",1,2:3"),
                Arguments.arguments("z//\\n1q2:3")
        );
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 올바르지 않으면 에러가 난다 ")
    @MethodSource("providedWrongCustomDelimiter")
    void invalidCustomDelimiter(String input) throws Exception {

        // then
        assertThatThrownBy(() -> Division.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER);
    }

    private static Stream<Arguments> providedWrongCustomDelimiter() {
        return Stream.of(
                Arguments.arguments("//\\n1,2 3"),
                Arguments.arguments("//\\n1q2:3")
        );
    }

}