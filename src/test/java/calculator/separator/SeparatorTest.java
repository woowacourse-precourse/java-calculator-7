package calculator.separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorTest {

    @DisplayName("구분자를 생성시 문자열의 길이가 1이 아닌 경우 예외가 발생한다.")
    @Test
    void createSeparator() {
        //given
        String str = "abc";

        //when
        Assertions.assertThatThrownBy(() -> new Separator(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 문자만 가능합니다.");
    }

}