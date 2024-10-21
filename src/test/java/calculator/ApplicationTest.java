package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_입력값_테스트() {
        System.setIn(new ByteArrayInputStream(" \n".getBytes())); // Simulate empty input

        assertThatThrownBy(Input::getInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식의 입력값입니다.");
    }

    @Test
    void 구분자만_존재하는_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;;;"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 입력되지 않았습니다.")
        );
    }

    @Test
    void 숫자만_존재하는_입력값() {
        assertThatThrownBy(() -> DelimiterExtractor.extractNumbers("24"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 입력되지 않았습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
