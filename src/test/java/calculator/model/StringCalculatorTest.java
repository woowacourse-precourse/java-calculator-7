package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("허용된 문자열 양식 검증 테스트")
    public void InputStringFromTest() {
        // given
        String input1 = "1:2,3";
        String input2 = "1,2,3";
        String input3 = "1:2:3";
        String input4 = "12:3456:789";

        // when
        String allowedFrom = stringCalculator.getAllowedFrom();

        // then
        assertThat(input1.matches(allowedFrom)).isTrue();
        assertThat(input2.matches(allowedFrom)).isTrue();
        assertThat(input3.matches(allowedFrom)).isTrue();
        assertThat(input4.matches(allowedFrom)).isTrue();
    }

    @Test
    @DisplayName("잘못된 양식의 문자열 검증 테스트")
    public void notAllowedFromTest() {
        // given
        String input = "1.2;3";

        // when, then
        assertThatThrownBy(() -> stringCalculator.claculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
