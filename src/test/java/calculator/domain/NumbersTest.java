package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("숫자의 총합 값을 구할 수 있다.")
    @Test
    void getTotalSum() {
        //given
        Number num1 = new Number(1);
        Number num2 = new Number(2);
        Number num3 = new Number(3);
        Numbers numbers = Numbers.from(List.of(num1, num2, num3));
        //when
        int totalSum = numbers.totalSum();
        //then
        assertThat(totalSum).isEqualTo(6);
    }

}