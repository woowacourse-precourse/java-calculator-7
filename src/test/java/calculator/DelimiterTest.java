package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 커스텀_구분자를_지정한다() {
        // given
        String input = "//;\\n1;2;3";
        
        // when
        Delimiter delimiter = Delimiter.createCustomDelimiter(input);
        
        // then
        assertThat(delimiter).isEqualTo(new Delimiter(";"));
    }

    @Test
    void 커스텀_구분자를_잘못_입력한_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Delimiter.createCustomDelimiter("/\\n1;2;3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 커스텀 구분자가 잘못된 형식입니다. 형식은 //와 구분자, 그리고 \\n으로 시작해야 합니다.");
    }

    @Test
    void 커스텀_구분자가_없는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Delimiter.createCustomDelimiter("//\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
    }
}
