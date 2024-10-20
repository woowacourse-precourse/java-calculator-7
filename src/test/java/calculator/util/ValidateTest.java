package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    void startWithValidationTest() {
        Assertions.assertThatThrownBy(() -> Converter.stringToNumbers("a1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Converter.stringToNumbers("/1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void delimiterValidationTest() {
        Assertions.assertThatThrownBy(() -> Converter.stringToNumbers("1;2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Converter.stringToNumbers("//;\n1.2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void customDelimiterValidationTest() {
        Assertions.assertThatThrownBy(() -> Converter.stringToNumbers("//\1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void success() {
        Converter.stringToNumbers("//test\n1test2,3:4test5");
        Converter.stringToNumbers("1,2:3");
    }
}