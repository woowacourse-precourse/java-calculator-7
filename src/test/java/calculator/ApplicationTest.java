package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 디폴트_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_및_디폴트_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
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
    void 예외_구분자에_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//234\\n-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_디폴트_구분자목록에_없는_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1!2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_구분자목록에_없는_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//.\\n-1!2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_끝나지_않는_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,.?!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_잘못된_구분자_입력_양식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/234\\n-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
