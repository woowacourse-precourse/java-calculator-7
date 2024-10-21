package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import calculator.Accumulator;
import calculator.splitter.DelegateDelimiterSplitter;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AccumulatorTest {

    @ParameterizedTest
    @MethodSource("patternAndSum")
    public void 합한값_반환(String input, int out) {
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(SplitterFixture.defaultSplitter());
        Accumulator accumulator = new Accumulator(splitter);

        assertThat(accumulator.sum(input)).isEqualTo(out);
    }

    static Stream<Arguments> patternAndSum() {
        return Stream.of(
                arguments("//.\n1.2.3", 1 + 2 + 3),
                arguments("1,1,2", 1 + 1 + 2),
                arguments("1:1:3", 1 + 1 + 3),
                arguments("1:3,2", 1 + 3 + 2),
                arguments("", 0),
                arguments(" ", 0),
                arguments("1,", 1));
    }
}
