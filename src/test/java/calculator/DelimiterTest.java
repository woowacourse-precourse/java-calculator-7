package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 커스텀_구분자를_지정한다2() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Delimiter delimiter = Delimiter.create(input);

        // then
        assertThat(delimiter).isEqualTo(new Delimiter(";"));
    }

    @Test
    void 기본_구분자를_지정한다() {
        // given
        String input = "1,2:3";

        // when
        Delimiter delimiter = Delimiter.create(input);

        // then
        assertThat(delimiter).isEqualTo(new Delimiter(",|:"));
    }

    @Test
    void 커스텀_구분자가_없는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Delimiter.create("//\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
    }

    @Test
    void 커스텀_구분자의_접미사의_위치를_반환한다() {
        // given
        String value = "//;\\n1;2;3";

        // when
        int customDelimiterSuffixIndex = Delimiter.locateCustomDelimiterSuffix(value);

        // then
        assertThat(customDelimiterSuffixIndex).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자인지_판별한다() {
        // given
        String input = "//;\\n1;2;3";

        // when
        boolean isCustomDelimiter = Delimiter.isCustomDelimiter(input);

        // then
        assertThat(isCustomDelimiter).isTrue();
    }
}
