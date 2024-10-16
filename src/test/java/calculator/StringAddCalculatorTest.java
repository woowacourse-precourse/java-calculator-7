package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("기본 구분자(콤마와 콜론)를 기준으로 숫자를 추출하여 합을 구한다.")
    void 기본_구분자로_숫자를_추출하여_합을_구한다() {
        // given
        String input = "1,2:3";

        // when
        int result = delimiterSplit(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    private int delimiterSplit(String input) {
        return sum(input.split("[,:]"));
    }

    private int sum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}