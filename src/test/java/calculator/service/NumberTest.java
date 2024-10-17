package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 숫자포함() {
        Assertions.assertThatThrownBy(() -> new Number("2131232w"));
        Assertions.assertThatThrownBy(() -> new Number("qwe"));
        Assertions.assertThatThrownBy(() -> new Number("2131232w"));
    }
}