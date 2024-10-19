package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DelimiterSeparatorTest {

    @Test
    void 기본_구분자를_기준으로_문자열을_분리한다() {
        // given
        String input = "1,2:3";

        // when
        String[] split = DelimiterSeparator.split(input);

        // then
        assertThat(split).isEqualTo(new String[]{"1", "2", "3"});
    }
}
