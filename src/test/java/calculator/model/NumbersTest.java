package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 확인")
class NumbersTest {
    private Numbers numbers;

    @Test
    @DisplayName("커스텀 구분자로 나눠진 숫자의 개수 확인")
    void numberCountWithCustomSeparator() {
        numbers = new Numbers(new CustomSeparator().separate("//;\\n1;2;3"));
        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    } // numberCountWithCustomSeparator

    @Test
    @DisplayName("기본 구분자로 나눠진 숫자의 개수 확인")
    void numberCountWithDefaultSeparator() {
        numbers = new Numbers(new DefaultSeparator().separate("1,2:3"));
        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    } // numberCountWithCustomSeparator

    @Test
    @DisplayName("양수 확인")
    void isPositive() {
        numbers = new Numbers(new CustomSeparator().separate("//-\\n-1-2--3"));
        assertThat(numbers.getNumbers().stream().allMatch(number -> number >= 0)).isTrue();
    }
} // class