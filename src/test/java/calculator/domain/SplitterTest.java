package calculator.domain;

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
    void 커스텀_구분자_추출() {
        // given
        String input = "//;\n1;2;3";
        // when
        String delimiter = splitter.extractDelimiter(input);
        // then
        assertThat(delimiter).isEqualTo("[,:]|;");
    }

    @Test
    void 기본_구분자가_사용() {
        // given
        String input = "1,2:3";
        // when
        String delimiter = splitter.extractDelimiter(input);
        // then
        assertThat(delimiter).isEqualTo("[,:]");
    }

    @Test
    void 잘못된_커스텀_구분자_형식() {
        // given
        String input = "//;\t1;2;";
        // when
        assertThatThrownBy(() -> splitter.extractDelimiter(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_DELIMITER_MSG);
    }
}
