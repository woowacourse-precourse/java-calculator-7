package calculator.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {

    Numbers numbers = new Numbers();

    @Test
    @DisplayName("숫자 목록에 새로운 숫자를 더한다")
    void addNumber() {
        //given
        int targetNumber = 5;
        List<Integer> numberList = numbers.getNumbers();

        //when
        numbers.addNumber(targetNumber);

        //then
        assertThat(numberList)
                .hasSize(1)
                .containsExactlyInAnyOrder(5);
    }

    @Test
    @DisplayName("등록된 숫자 목록을 조회한다")
    void getNumbers() {
        //given
        List<Integer> numbersList = numbers.getNumbers();

        //when
        numbers.addNumber(0,6,71);
        System.out.println(numbersList);
        //then
        assertThat(numbersList)
                .hasSize(3)
                .containsExactlyInAnyOrder(0, 6, 71);
    }

    @Test
    @DisplayName("음수를 추가할 경우 예외가 발생한다")
    void addNegativeNumber() {
        //given
        List<Integer> numbersList = numbers.getNumbers();

        //when //then
        assertThatThrownBy(() -> numbers.addNumber(-1,6,71))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(numbersList).hasSize(0);
    }

    @Test
    @DisplayName("Null값을 추가할 경우 예외가 발생한다")
    void addNull() {
        //given
        List<Integer> numbersList = numbers.getNumbers();
        Integer target = null;

        //when //then
        assertThatThrownBy(() -> numbers.addNumber(target))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(numbersList).hasSize(0);
    }

    @Test
    @DisplayName("숫자 목록의 합을 구한다")
    void sumNumbers() {
        //given
        List<Integer> numberList = numbers.getNumbers();
        numbers.addNumber(1, 5, 10);

        //when
        Integer total = numbers.sumNumbers();

        //then
        assertThat(total).isEqualTo(16);
    }
}