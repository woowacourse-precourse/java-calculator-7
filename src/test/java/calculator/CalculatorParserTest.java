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
                Arguments.of("//;\\n1", List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource("provide3")
    void 커스텀_구분자로_2자_이상이_값이_올_수_없다(String input) {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse(input);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("커스텀 구분자로 2자 이상이 올 수 없습니다.");
    }

    private static Stream<Arguments> provide3() {
        return Stream.of(

                Arguments.of("//AAA\n1AAA2AAA3"),
                Arguments.of("////\n1//2//3")
        );
    }

    @Test
    void 커스텀_구분자로_빈_값이_올_수_없다() {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse("//\n\n13:A:2");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("커스텀 구분자로 빈 값이 올 수 없습니다.");
    }

    @Test
    void 커스텀_구분자로_숫자가_올_수_없다() {
        // when
        Throwable exception = assertThrows(CalculatorParsedException.class, () -> {
            CalculatorParser.parse("//3\n13:2:2");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("커스텀 구분자로 숫자가 올 수 없습니다.");
    }

    @Test
    void 정수만_입력_할_수_있습니다() {
        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorParser.parse("-1:2:A");
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("정수만 입력할 수 있습니다.");
    }
}