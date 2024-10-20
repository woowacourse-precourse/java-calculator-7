package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import calculator.AbstractDelimiterSplitter;
import calculator.CustomDelimiterSplitter;
import calculator.DefaultDelimiterSplitter;
import calculator.DelegateDelimiterSplitter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DelegateDelimiterSplitterTest {

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void 문자분리(String value, List<String> result) {
        List<AbstractDelimiterSplitter> splitters = List.of(
                new DefaultDelimiterSplitter(1),
                new CustomDelimiterSplitter(0));
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(splitters);

        assertThat(splitter.split(value)).containsExactlyInAnyOrderElementsOf(result);
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("//.\n1.2.3", Arrays.asList("1", "2", "3")),
                arguments("1,1,2", Arrays.asList("1", "1", "2")),
                arguments("1:1:3", Arrays.asList("3", "1", "1")),
                arguments("1:3,2", Arrays.asList("1", "2", "3")));
    }

    @Test
    public void 빈_문자열_분리() {
        List<AbstractDelimiterSplitter> splitters = List.of(
                new DefaultDelimiterSplitter(1),
                new CustomDelimiterSplitter(0));
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(splitters);

        assertThat(splitter.split("")).isEqualTo(List.of(""));
    }
}
