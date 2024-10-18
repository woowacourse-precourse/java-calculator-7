package calculator.model;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("기본 구분자 확인")
class DefaultSeparatorTest {
    @Test
    @DisplayName("기본 구분자 포함 확인")
    void containsDefaultSeparator() {
        assertThat(new CalculatorController().containsDefaultSeparator("1:2:3")).isTrue();
    } // containsDefaultSeparator

    @Test
    @DisplayName("기본 구분자 예외 확인")
    void isDefaultSeparatorException() {
        assertThatThrownBy(() -> new DefaultSeparator().separate("1,2!3"))
                .isInstanceOf(IllegalArgumentException.class);
    } // isDefaultSeparatorException
} // class