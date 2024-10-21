package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputMessageTest {

    @Test
    void trim() {
        Assertions.assertThat(new UserInputMessage("   12345   ").toString())
                .isEqualTo("12345");
    }
}