package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.CustomDelimiterSplitter;
import calculator.SplitResult;
import org.junit.jupiter.api.Test;

public class CustomDelimiterSplitterTest {

    @Test
    public void 커스텀_구분자() {
        CustomDelimiterSplitter splitter = new CustomDelimiterSplitter();

        SplitResult result = splitter.split("//.\n1.1.3");

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.result()).containsExactlyInAnyOrder("1", "1", "3");
    }
}
