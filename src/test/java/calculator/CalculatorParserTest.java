package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
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
                Arguments.of("1,2:3", List.of(1, 2, 3))
        );
    }
}