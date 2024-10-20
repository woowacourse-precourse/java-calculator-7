package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.DefaultDelimiterSplitter;
import calculator.SplitResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultDelimiterSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,1,3", "1:3:1", "1,1:3"})
    public void 기본구분자_분리(String value) {
        DefaultDelimiterSplitter splitter = new DefaultDelimiterSplitter();

        SplitResult result = splitter.split(value);

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.result()).containsExactlyInAnyOrder("3", "1", "1");
    }
}
