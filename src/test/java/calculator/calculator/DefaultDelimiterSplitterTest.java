package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.DefaultDelimiterSplitter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DefaultDelimiterSplitterTest {

    @Test
    public void 기본구분자_분리() {
        String value = "1,1,3";
        DefaultDelimiterSplitter tokenizer = new DefaultDelimiterSplitter();

        List<String> result = tokenizer.split(value);

        assertThat(result).containsExactlyInAnyOrder("3", "1", "1");
    }
}
