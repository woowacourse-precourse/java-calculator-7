package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("커스텀 구분자 사용 : 성공")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest
    @ValueSource( strings = {
            "1=3:2",
            "A,2:1",
            "+1,1:1",
            "-1:1,1",
            "/a\n1a3a2",
            "//a\n10a3:2",
            "//a\n10a3,2",
            "//\n132",
            "//&\n1|3&2"
    })
    @DisplayName("잘못된 input 입력 시, 예외 발생")
    void inputException(String input) {
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
