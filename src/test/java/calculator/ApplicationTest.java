package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("커스텀 구분자를 사용해서 계산했을 때 올바른 값을 도출한다.")
    void 계산_성공_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "//\\n1", "//;1;2", "1,2:", "1,a,2"})
    @DisplayName("잘못된 입력값에 대해 IllegalArgumentException이 발생해야 한다.")
    void 예외_발생_잘못된_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
