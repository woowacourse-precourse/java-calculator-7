package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("커스텀 구분자 테스트")
class CustomDelimiterTest {

    @Test
    @DisplayName("커스텀 구분자가 3개를 초과하면 예외가 발생한다.")
    void isCustomDelimiterCountExceedLimit() {
        assertThatThrownBy(() -> new CustomDelimiter(";!?#").validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[R0001]");
    }

    @Test
    @DisplayName("커스텀 구분자가 3개를 이하이면 예외가 발생하지 않는다.")
    void isCustomDelimiterCountBelowLimit() {
        assertThatCode(() -> new CustomDelimiter(";!?").validate())
                .doesNotThrowAnyException();
    }

}