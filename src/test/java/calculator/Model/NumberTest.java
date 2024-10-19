package calculator.Model;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest extends NsTest {
    @ParameterizedTest
    @DisplayName("불가능한 숫자 객체를 확인합니다.")
    @ValueSource(strings = {".", ";", ":", "//", "\\\\n", "-1.0", "-1", "0", "-1020394"})
    void number_테스트(String input) {
        Assertions.assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
