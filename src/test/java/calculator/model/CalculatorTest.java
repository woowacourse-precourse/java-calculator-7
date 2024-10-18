package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 계산기_생성() {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator).isNotNull();
    }
}
