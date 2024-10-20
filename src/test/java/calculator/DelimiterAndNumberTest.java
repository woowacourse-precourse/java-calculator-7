package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterAndNumberTest {

    @DisplayName("입력값의 가장 처음이 구분자이면, 예외를 반환하는 메서드를 테스트하라")
    @Test
    void test_validateStart() {
        DelimiterAndNumber delimiterAndNumber = new DelimiterAndNumber(":|,", ":1:23:3");

        assertThatThrownBy(delimiterAndNumber::validateStart)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력의 첫 글자가 구분자입니다. 올바른 형식으로 다시 입력해 주세요.");
    }

    @DisplayName("구분자가 연속되면, 예외를 반환하는 메서드를 테스트하라")
    @Test
    void test_splitNumbers_with_error() {
        DelimiterAndNumber delimiterAndNumber = new DelimiterAndNumber(":|,", "1::23::3");

        assertThatThrownBy(delimiterAndNumber::splitNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 구분자가 입력되었습니다. 올바른 형식으로 다시 입력해 주세요.");
    }

    @DisplayName("입력한 문자열을 구분자를 기준으로 나눠 모은 문자열 배열로 반환하는 메서드를 테스트하라")
    @Test
    void test_splitNumbers() {
        DelimiterAndNumber delimiterAndNumber = new DelimiterAndNumber(":|,", "1:2:3");

        String[] numbers = delimiterAndNumber.splitNumbers();

        Assertions.assertThat(numbers).containsExactly("1", "2", "3");
    }
}
