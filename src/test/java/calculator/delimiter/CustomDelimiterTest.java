package calculator.delimiter;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterTest {

    @Test
    void 커스텀_구분자_시작_확인_검증_실패() {
        //given
        String input = "1,2,3";

        //when
        boolean hasCustomDelimiter = CustomDelimiter.hasCustomDelimiter(input);

        //then
        assertThat(hasCustomDelimiter).isFalse();
    }

    @Test
    void 커스텀_구분자_시작_확인_검증_성공() {
        //given
        String input = "//1,2,3";

        //when
        boolean hasCustomDelimiter = CustomDelimiter.hasCustomDelimiter(input);

        //then
        assertThat(hasCustomDelimiter).isTrue();
    }

    @Test
    void 커스텀_구분자_리스트_반환() {
        //when
        Set<String> delimiters = CustomDelimiter.getCustomDelimiters("|");

        //then
        assertThat(delimiters).containsExactly(":", ",", "|");
    }
}