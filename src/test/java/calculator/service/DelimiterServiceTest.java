package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterServiceTest {

    DelimiterService delimiterService;

    @BeforeEach
    void setUp() {
        delimiterService = new DelimiterService();
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 사용하면 예외가 발생한다.")
    void 커스텀_구분자에_숫자를_사용하면_예외_발생() {
        // given
        String input = "//1\\n21415";

        // when, then
        assertThatThrownBy(() -> delimiterService.splitNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 문자에 숫자를 입력할 수 없습니다.");
    }

}