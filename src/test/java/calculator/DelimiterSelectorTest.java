package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterSelectorTest {
    @Test
    void isNotCustomDelimiterTest() {
        String input = "1;2";
        DelimiterSelector delimiterSelector = new DelimiterSelector();

        boolean result = delimiterSelector.isCustomDelimiter(input);

        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void isCustomDelimiterTest() {
        String input = "//.\n1.2";
        DelimiterSelector delimiterSelector = new DelimiterSelector();

        boolean result = delimiterSelector.isCustomDelimiter(input);

        Assertions.assertThat(result).isEqualTo(true);
    }
}
