package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("숫자들의 합을 반환한다.")
    @Test
    void calculateTotalSum() {
        //given
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        //when
        Integer totalSum = numbers.totalSum();
        //then
        assertThat(totalSum).isEqualTo(6);
    }

}