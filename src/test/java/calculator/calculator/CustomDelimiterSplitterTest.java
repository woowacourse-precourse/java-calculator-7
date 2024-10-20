package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.CustomDelimiterSplitter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CustomDelimiterSplitterTest {

    @Test
    public void 커스텀_구분자() {
        CustomDelimiterSplitter splitter = new CustomDelimiterSplitter();

        List<String> result = splitter.split("//.\n1.1.3");

        assertThat(result).containsExactlyInAnyOrder("1", "1", "3");
    }
}
