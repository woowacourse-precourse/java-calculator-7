package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerParserTest {
    private final IntegerParser parser = new IntegerParser();

    @Test
    void 정상_숫자_파싱_테스트() {
        assertThat(parser.parse("1")).isEqualTo(1);
    }

    @Test
    void 빈_문자열_파싱_테스트() {
        assertThat(parser.parse("")).isEqualTo(0);
    }

    @Test
    void 커스텀_문자가_아닌_문자가_파싱된_테스트() {
        assertThatThrownBy(() -> parser.parse("2a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

