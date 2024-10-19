package calculator;

import calculator.separator.DefaultSeparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultSeparatorTest {

    @Test
    public void 디폴트_구분자_테스트() {
        // given
        String input = "23:3,74,03";

        // when
        DefaultSeparator separator = new DefaultSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"23", "3", "74", "03"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 디폴트_구분자로만_분리() {
        // given
        String input = "62&13^6:9,8::50";

        // when
        DefaultSeparator separator = new DefaultSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"62&13^6", "9", "8", "", "50"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
