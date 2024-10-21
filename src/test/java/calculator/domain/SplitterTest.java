package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitterTest {
    private Splitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new Splitter(new Validator());
    }

    @Test
    void 커스텀_구분자를_사용한_문자열_분리() {
        // given
        String input = "//;\\n1;2;3";
        // when
        List<String> result = splitter.splitInputByDelimiter(input);
        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자를_사용한_문자열_분리() {
        // given
        String input = "1,2:3";
        // when
        List<String> result = splitter.splitInputByDelimiter(input);
        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 잘못된_커스텀_구분자_형식() {
        // given
        String input = "//\n1,2,3";
        // when
        assertThatThrownBy(() -> splitter.splitInputByDelimiter(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_DELIMITER_MSG);
    }

    @Test
    void 입력값이_비어있는_경우_예외() {
        // given
        String input = "   ";
        // when
        assertThatThrownBy(() -> splitter.splitInputByDelimiter(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_INPUT_MSG);
    }

}
