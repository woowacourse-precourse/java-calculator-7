package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


class ApplicationTest extends NsTest {

    @Test
    void 구분자_없는_숫자() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run("11,2,3");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("11:2:3");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n11;2");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 긴_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//!@#\\n1!@#2!@#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표_콜론_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("\n")) // 빈 문자열
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;;2;;3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_아닌_문자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3,a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
