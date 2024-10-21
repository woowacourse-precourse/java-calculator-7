package calculator.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AdditionResultTest {
    @Test
    void 소수점_없는_결과값_변환() {
        double result = 123.0;

        AdditionResult additionResult = AdditionResult.from(result);

        assertThat(additionResult.result()).isEqualTo("123");
    }

    @Test
    void 소수점_있는_결과값_변환() {
        double result = 123.456;

        AdditionResult additionResult = AdditionResult.from(result);

        assertThat(additionResult.result()).isEqualTo("123.456");
    }
}