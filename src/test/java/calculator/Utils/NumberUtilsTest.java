package calculator.Utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class NumberUtilsTest extends NsTest {

    @ParameterizedTest
    @DisplayName("주어진 문자열이 실수가 아닌지 확인합니다.")
    @ValueSource(strings = {"a", "b", ";", ".", ":"})
    void 유틸리티_isDouble_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("주어진 숫자가 .0으로 떨어지는지 확인합니다.")
    @ValueSource(doubles = {10.0, 200.0, 9.0, 7.0, 17.0})
    void 유틸리티_isInt_테스트_true(double realNumber) {
        boolean result = NumberUtils.isInt(realNumber);

        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("주어진 숫자가 .0으로 떨어지지 않는지 확인합니다.")
    @ValueSource(doubles = {10.1, 200.9, 9.5, 7.3, 17.2})
    void 유틸리티_isInt_테스트_false(double realNumber) {
        boolean result = NumberUtils.isInt(realNumber);

        assertThat(result).isEqualTo(false);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
