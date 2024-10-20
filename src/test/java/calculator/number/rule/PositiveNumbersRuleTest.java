package calculator.number.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersRuleTest {

    PositiveNumbersRule rule = new PositiveNumbersRule();

    @Test
    @DisplayName("음수를 포함한다면 invalid")
    void test1() {
        int[] values = {-1, 2, -3, 4};
        Assertions.assertThat(rule.isInvalid(values)).isTrue();
    }

    @Test
    @DisplayName("0을 포함한다면 invalid")
    void test2() {
        int[] values = {1, 2, 0, 4};
        Assertions.assertThat(rule.isInvalid(values)).isTrue();
    }

    @Test
    @DisplayName("양수만 있다면 valid")
    void test3() {
        int[] values = {1, 2, 3, 4};
        Assertions.assertThat(rule.isInvalid(values)).isFalse();
    }

}