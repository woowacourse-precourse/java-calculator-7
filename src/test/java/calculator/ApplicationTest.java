package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 예외_테스트_숫자_커스텀() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//1\\n1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 숫자로 지정할 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트_문자열_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2*3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자 이외의 문자가 포함되어 있습니다:")
        );
    }

    @Test
    void 예외_테스트_문자열_입력없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("덧셈을 진행할 문자열을 입력하세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
