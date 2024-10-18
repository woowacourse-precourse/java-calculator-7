package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    @DisplayName("numbers에 아무것도 들어가 있지 않을 떄는 합이 0이 나와야한다.")
    void whenNoNumbers() {
        // given
        List<Integer> number = new ArrayList<>();
        Numbers numbers = new Numbers(number);
        // when
        Integer result = numbers.sumNumbers();
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("정상 작동 - numbers에 들어가 있는 모든 숫자를 더한다.")
    void success() {
        //given
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            number.add(i);
        }
        Numbers numbers = new Numbers(number);
        //when
        Integer result = numbers.sumNumbers();
        // then
        assertThat(result).isEqualTo(45);
    }
}