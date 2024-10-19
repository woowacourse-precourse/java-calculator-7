package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersTest {

    @Test
    @DisplayName("양수들: 0은 기본값, 덧셈에 영향을 주지 않는다")
    void 양수들_0은_기본값으로_포함하지_않는다() {
        assertThatNoException().isThrownBy(() ->
                PositiveNumbers.from(List.of("0", "1", "2", "3")));
    }

}
