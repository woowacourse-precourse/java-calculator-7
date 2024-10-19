package calculator.Model;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DelimiterTest extends NsTest {

    @ParameterizedTest
    @DisplayName("불가능한 구분자를 확인합니다.")
    @ValueSource(strings = {"6", "", " ", ".", "19.0"})
    void delimiter_테스트_false(String input) {
        Assertions.assertThatThrownBy(() -> new Delimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
