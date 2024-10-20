package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.CalculatorParsedException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorParserTest {

    @ParameterizedTest
    @MethodSource("provide1")
    void 기본_구분자를_기준으로_파싱할_수_있다(String input, List<Integer> guess) {
        // when
        List<Integer> ret = CalculatorParser.parse(input);

        // then
        assertThat(ret).isEqualTo(guess);
    }

    private static Stream<Arguments> provide1() {
        return Stream.of(
                Arguments.of("1:2:3", List.of(1, 2, 3)),
                Arguments.of("1,2,3", List.of(1, 2, 3)),
                Arguments.of("1,2:33", List.of(1, 2, 33))
        );
    }

    @ParameterizedTest
    @MethodSource("provide2")
    void 커스텀_구분자를_기준으로_파싱할_수_있다(String input, List<Integer> guess) {
        // when
        List<Integer> ret = CalculatorParser.parse(input);

        // then
        assertThat(ret).isEqualTo(guess);
    }

    private static Stream<Arguments> provide2() {
        return Stream.of(
                Arguments.of("//A\n1A2A3", List.of(1, 2, 3)),
                Arguments.of("//?\n1?2:3", List.of(1, 2, 3)),
                Arguments.of("//;\\n1", List.of(1)),
                Arguments.of("//AAA\n1AAA2AAA3", List.of(1, 2, 3)),
                Arguments.of("////\n1//2//3", List.of(1, 2, 3)),
                Arguments.of("//\n\n1\n2\n3", List.of(1, 2, 3)),
                Arguments.of("//\\n\\n1\\n2\\n3", List.of(1, 2, 3))
        );
    }

    @Test
    void 커스텀_구분자로_빈_값이_올_수_없다() {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse("//\n13:A:2");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(CalculatorParsedException.EMPTY_CUSTOM_DELIMITER);
    }

    @Test
    void 커스텀_구분자로_숫자가_올_수_없다() {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse("//3\n13:2:2");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(CalculatorParsedException.CUSTOM_NOT_NUMERIC);
    }

    @ParameterizedTest
    @MethodSource("provide3")
    void 표현식에는_정수만_입력_할_수_있습니다(String input) {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse(input);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(CalculatorParsedException.POSITIVE_EXPRESSION);
    }

    private static Stream<Arguments> provide3() {
        return Stream.of(
                Arguments.of("-1:2:3"),
                Arguments.of("2:-1:3"),
                Arguments.of("//?\n2?-1?3"),
                Arguments.of("//?\n2?A?3"),
                Arguments.of("//^\n1?A?2")
        );
    }

    @ParameterizedTest
    @MethodSource("provide4")
    void 표현식에는_빈_값이_올_수_없습니다(String input) {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse(input);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(CalculatorParsedException.EMPTY_EXPRESSION);
    }

    private static Stream<Arguments> provide4() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("//?\n")
        );
    }

    @Test
    void Integer보다_큰_값을_표현식에_사용할_수_없습니다() {
        assertThrows(NumberFormatException.class, () -> {
            CalculatorParser.parse("2111412941209438124902148");
        });
    }
}