package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용1() {
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
                .hasMessage("-1: 음수는 입력할 수 없습니다.")
        );
    }

    @Test
    void 문자를_더하면_에러가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//]\\n1]a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("a: 양의 정수가 아닙니다."));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
