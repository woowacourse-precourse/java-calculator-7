package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }


    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2,3:4,5:6,10");
            assertThat(output()).contains("결과 : 31");
        });
    }

    @Test
    void 구분자_사이_숫자없음() {
        assertSimpleTest(() -> {
            run("1:,3:4,5:6,10");
            assertThat(output()).contains("결과 : 29");
        });
    }

    @Test
    void 공백_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자아닌_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("o,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_외_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:4/5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_없음_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_두개_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;,\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
