package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SumValueTest {

    @Test
    @DisplayName("SumValue는_양의_정수로_생성될_수_있다")
    public void create() {
        //given
        //when
        SumValue result = new SumValue(1);

        //then
        assertThat(result.getValue()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("SumValue는_양의_정수가_아니면_예외를_던진다")
    public void notPositiveNumException() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new SumValue(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력");
    }
}