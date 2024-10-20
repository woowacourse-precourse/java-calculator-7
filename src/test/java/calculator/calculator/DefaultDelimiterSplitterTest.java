package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.DefaultDelimiterSplitter;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultDelimiterSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,1,3", "1:3:1", "1,1:3"})
    public void 기본구분자_분리(String value) {
        DefaultDelimiterSplitter tokenizer = new DefaultDelimiterSplitter();

        List<String> result = tokenizer.split(value);

        assertThat(result).containsExactlyInAnyOrder("3", "1", "1");
    }
}
