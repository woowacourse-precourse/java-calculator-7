package calculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputFilterTest {

    @Test
    @DisplayName("형식에 올바른 입력을 하면 정상적으로 작동한다")
    void do_filter() {
        String input = "//*\\n8*8*";

        Assertions.assertDoesNotThrow(() -> InputFilter.doOutWrong(input));
    }

    @Test
    @DisplayName("형식에 올바르게 입력하지 않으면 IllegalArgue 타입의 예외 문구가 뜬다")
    void throws_when_delimiter_is_not_default() {
        String input = "5,6/7";

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> InputFilter.doOutWrong(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력 형식입니다.");
    }
}
