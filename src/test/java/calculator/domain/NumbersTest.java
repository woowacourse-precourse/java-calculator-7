package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("숫자를 생성 하면 빈 리스트가 생성된다.")
    @Test
    void constructNumbers() {
        //given
        Numbers numbers = new Numbers();
        //when
        //then
        assertThat(numbers)
            .extracting("numbers")
            .isEqualTo(List.of());
    }

    @DisplayName("숫자를 추가할 수 있다.")
    @Test
    void addNumber() {
        //given
        int num = 1;
        Numbers numbers = new Numbers();
        //when
        numbers.addNumber(num);
        //then
        assertThat(numbers)
            .extracting("numbers")
            .isEqualTo(List.of(1));
    }

    @DisplayName("숫자들의 총합을 구할 수 있다.")
    @Test
    void calculateTotalSum() {
        //given
        Numbers numbers = new Numbers();
        //when
        numbers.addNumber(1);
        numbers.addNumber(2);
        numbers.addNumber(3);

        //then
        assertThat(numbers.totalSum()).isEqualTo(6);
    }

}