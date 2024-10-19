package calculator;

import static calculator.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Division;
import calculator.util.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DivisionTest {

    @ParameterizedTest
    @DisplayName("문자열이 주어지면 기본 구분자로 문자열을 분리한다")
    @MethodSource("providedDefaultNumber")
    void defaultDelimiter(String input, List<String> answer) throws Exception {
        // given
        Division division = new Division();

        // when
        List<String> split = division.split(input);

        // then
        assertThat(split).hasSize(3)
                .containsAll(answer);
    }

    private static Stream<Arguments> providedDefaultNumber() {
        return Stream.of(
                Arguments.arguments("1,2:3", List.of("1", "2", "3")),
                Arguments.arguments("1,2,3", List.of("1", "2", "3")),
                Arguments.arguments("1:2:3", List.of("1", "2", "3")),
                Arguments.arguments("1:2,3", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 주어지면 커스텀 구분자로만 문자열을 나눈다")
    @MethodSource("providedCustomNumber")
    void delimiter(String input, List<String> answer) throws Exception {
        // given
        Division division = new Division();

        // when
        List<String> split = division.split(input);

        // then
        assertThat(split).hasSize(3)
                .containsAll(answer);
    }

    private static Stream<Arguments> providedCustomNumber() {
        return Stream.of(
                Arguments.arguments("//;\\n1;2;3", List.of("1", "2", "3")),
                Arguments.arguments("//q\\n1q2q3", List.of("1", "2", "3")),
                Arguments.arguments("// \\n1 2 3", List.of("1", "2", "3")),
                Arguments.arguments("//ab\\n1ab2ab3", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest
    @DisplayName("포맷에 맞지 않는 값을 입력하면 에러가 난다")
    @MethodSource("providedWrongFormat")
    void invalidFormat(String input) throws Exception {
        // given
        Division division = new Division();

        // when

        // then
        assertThatThrownBy(() -> division.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_FORMAT.getMessage());
    }

    private static Stream<Arguments> providedWrongFormat() {
        return Stream.of(
                Arguments.arguments(",1,2:3"),
                Arguments.arguments("z//\\n1q2:3"),
                Arguments.arguments("/\\n1q2:3"),
                Arguments.arguments("//\\1q2:3"),
                Arguments.arguments("//\\a1q2:3")
        );
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분 포맷에 맞지 않으면 에러를 반환한다")
    @MethodSource("providedWrongCustomDelimiterFormat")
    void invalidCustomDelimiterFormat(String input) throws Exception {
        // given
        Division division = new Division();

        // when

        // then
        assertThatThrownBy(() -> division.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    private static Stream<Arguments> providedWrongCustomDelimiterFormat() {
        return Stream.of(
                Arguments.arguments("//\\n1q2:3"),
                Arguments.arguments("//c\\nn1q2:3"),
                Arguments.arguments("//n\\n-a1q2:3"),
                Arguments.arguments("//\\n1,2 3"),
                Arguments.arguments("//\\n1q2:3")
        );
    }

    @ParameterizedTest
    @DisplayName("기본 구분자를 또 입력하면 에러를 반환한다 ")
    @MethodSource("providedDuplicateDelimiter")
    void DuplicateCustomDelimiter(String input) throws Exception {
        // given
        Division division = new Division();

        // then
        assertThatThrownBy(() -> division.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_DELIMITER.getMessage());
    }

    private static Stream<Arguments> providedDuplicateDelimiter() {
        return Stream.of(
                Arguments.arguments("//:\\n1,2 3"),
                Arguments.arguments("//,\\n1q2:3")
        );
    }

}