package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimiterCheckerTest {

    @Test
    void 아무것도_입력하지_않는다() {
        // given
        String 빈_입력 = "";
        DelimiterChecker delimiterChecker = new DelimiterChecker();
        delimiterChecker.putString(빈_입력);

        // when
        List<Integer> result = delimiterChecker.getNumbers();

        // then
        assertThat(result).isEqualTo(List.of());
    }

    @Test
    void 지정되지_않은_구분자를_입력한다() {
        // given
        String 지정되지_않은_구분자가_포함된_입력 = "1?2,40";
        DelimiterChecker delimiterChecker = new DelimiterChecker();
        delimiterChecker.putString(지정되지_않은_구분자가_포함된_입력);

        // when & then
        assertThatThrownBy(() -> delimiterChecker.getNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오버플로우를_일으키는_값을_입력한다() {
        // given
        String integer_최대값을_넘는_입력 = "2147483648";
        DelimiterChecker delimiterChecker = new DelimiterChecker();
        delimiterChecker.putString(integer_최대값을_넘는_입력);

        // when & then
        assertThatThrownBy(() -> delimiterChecker.getNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
