package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiterTest() {
        Validator validator = new Validator();
        String[] strings = validator.validateInput("//!\\n1!2!3");
        assertThat(strings).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("빈 입력 테스트")
    void emptyInputTest() {
        Validator validator = new Validator();
        String[] strings = validator.validateInput("");
        assertThat(strings).isEqualTo(new String[]{"0"});
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void defaultDelimiterTest() {
        Validator validator = new Validator();
        String[] strings = validator.validateInput("1,2:3");
        assertThat(strings).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자 혼합 테스트")
    void mixDelimiterTest() {
        Validator validator = new Validator();
        String[] strings = validator.validateInput("//!\\n1,2:3!4");
        assertThat(strings).isEqualTo(new String[]{"1", "2", "3", "4"});
    }

    @Test
    @DisplayName("양수 확인 테스트")
    void positiveNumTest() {
        Validator validator = new Validator();
        int number = validator.validatePositiveNum("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("음수 확인 테스트")
    void negativeNumTest() {
        Validator validator = new Validator();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> validator.validatePositiveNum("-1"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 확인 테스트")
    void notNumberTest() {
        Validator validator = new Validator();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> validator.validatePositiveNum("a"));
    }
}