package calculator.model;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NewParserTest {

    @Test
    void 쉼표와_콜론을_구분자로_가지는_문자열의_합_출력() {
        Assertions.assertThat(NewParser.sum("1,2,3")).isEqualTo(6);
        Assertions.assertThat(NewParser.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 빈문자_입력시_0_반환() {
        Assertions.assertThat(NewParser.sum("")).isEqualTo(0);
        Assertions.assertThat(NewParser.sum(null)).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_조건_짝이_안맞는_경우() {
        assertThrows(IllegalArgumentException.class, () -> NewParser.sum("//;n1,2,3"));
    }

}