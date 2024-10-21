package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberStringTest {
    @Test
    void parseTest(){
        String normalCase = "123:456";
        String hasCustomCase = "//;\\n1";
        String invalidCase = "-123,345";

        assertThat(NumberString.parse(normalCase))
                .containsExactly("123", "456");
        assertThat(NumberString.parse(hasCustomCase))
                .containsExactly("1");
        assertThatThrownBy(()->NumberString.parse(invalidCase))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
