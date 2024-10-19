package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    public void 입력된_값이_양수가_아닐_때_에러_발생(){
        //When & Then
        Assertions.assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값이 양수가 아닙니다.");
    }
}
