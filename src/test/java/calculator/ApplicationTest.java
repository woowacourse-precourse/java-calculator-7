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
    void 기본_구분자_콤마만_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_콜론만_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자를_섞어서_사용() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_문자열이_있는_경우_0으로_계산한다() {
        assertSimpleTest(() -> {
            run(",2,,4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자는_동시에_사용할_수_있다() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자는_문자열_맨_앞에_위치해야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자는_올바른_형식으로_제공되어야_한다1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자는_올바른_형식으로_제공되어야_한다2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_문자는_커스텀_구분자로_설정할_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_문자열이_0으로_시작하는_것은_사용할_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수점이_존재하는_숫자는_사용할_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,1.23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
