package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositiveNumberTest {
    @Test
    void 덧셈_결과가_양수인지_확인() {
        // given
        PositiveNumber sum = new PositiveNumber(0);
        String[] numbers = {String.valueOf(Integer.MAX_VALUE), "1"};

        // when & then
        assertThatThrownBy(() -> addNumbersAndCheckOverflow(sum, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과값이 양수가 아닙니다. 큰 수를 더했을 수 있습니다.");
    }

    private void addNumbersAndCheckOverflow(PositiveNumber sum, String[] numbers) {
        for (String number : numbers) {
            sum.plus(number); // 이 부분에서 예외가 발생해야 함
        }
    }
}
