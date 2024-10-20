package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DelimiterSelectorTest {
    private DelimiterSplitter delimiterSelector;

    @BeforeEach
    void setup() {
        delimiterSelector = new DelimiterSplitter();
    }

    @Test
    void isNotCustomDelimiterTest() {
        String input = "1;2";

        boolean result = delimiterSelector.isCustomDelimiter(input);

        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void isCustomDelimiterTest() {
        String input = "//.\n1.2";

        boolean result = delimiterSelector.isCustomDelimiter(input);

        Assertions.assertThat(result).isEqualTo(true);
    }
}
