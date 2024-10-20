package calculator.calculator.spliter;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.splitter.CustomDelimiterSplitter;
import calculator.splitter.SplitResult;
import org.junit.jupiter.api.Test;

public class CustomDelimiterSplitterTest {

    @Test
    public void 커스텀_구분자() {
        CustomDelimiterSplitter splitter = new CustomDelimiterSplitter();

        SplitResult result = splitter.split("//.\n1.1.3");

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.result()).containsExactlyInAnyOrder("1", "1", "3");
    }

    @Test
    public void 커스텀_구분자_매칭_실패() {
        CustomDelimiterSplitter splitter = new CustomDelimiterSplitter();

        SplitResult result = splitter.split("/.\n1.1.3");

        assertThat(result.isSuccess()).isFalse();
    }
}
