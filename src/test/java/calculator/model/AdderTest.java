package calculator.model;

import calculator.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdderTest {

    @Test
    @DisplayName("덧셈 검사")
    void addTest() {
        Adder adder = new Adder(new Validator());
        String result = adder.addNums(new String[]{"1", "2", "3"});
        Assertions.assertThat(result).isEqualTo("6");
    }
}