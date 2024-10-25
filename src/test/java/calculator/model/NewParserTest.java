package calculator.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NewParserTest {

    @Test
    void 쉼표와_콜론을_구분자로_가지는_문자열의_합_출력() {
        Assertions.assertThat(NewParser.sum("1,2,3")).isEqualTo(6);
        Assertions.assertThat(NewParser.sum("1,2:3")).isEqualTo(6);
    }
}