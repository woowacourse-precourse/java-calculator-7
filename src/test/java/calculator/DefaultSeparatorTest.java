package calculator;

import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
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

    @Test
    public void 빈_문자열_입력() {
        // given
        String input = "";

        // when
        DefaultSeparator separator = new DefaultSeparator(input);
        String[] actual = separator.splitLine();

        // then
        Assertions.assertThat(actual).isEqualTo(null);
    }

    @Test
    public void 숫자없이_구분자만_입력() {
        // given
        String input = ",:::,";

        // when
        Separator separator = new DefaultSeparator(input);
        String[] actual = separator.splitLine();

        // then
        Assertions.assertThat(actual).isEqualTo(null);
    }
}
