package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    void split() {
        assertThat(StringUtil.splitText("1,2,3", ",")).containsExactly("1", "2", "3");
    }
}
