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
    void 커스텀_구분자_숫자사용() {
        assertSimpleTest(() -> {
            run("//7\\n7172");
            assertThat(output()).contains("결과 : 3");
        });
    }
    @Test
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_미사용_소수계산() {
        assertSimpleTest(() -> {
            run("1.1,2.1,3.1");
            assertThat(output()).contains("결과 : 6.3");
        });
    }
    @Test
    void 커스텀_구분자_사용_소수계산() {
        assertSimpleTest(() -> {
            run("//;\\n1.1;2.1,3.1");
            assertThat(output()).contains("결과 : 6.3");
        });
    }
    @Test
    void 커스텀_구분자_숫자사용_소수계산() {
        assertSimpleTest(() -> {
            run("//7\\n1.172.1,3.1");
            assertThat(output()).contains("결과 : 6.3");
        });
    }
    @Test
    void 커스텀_구분자_숫자사용_계산할숫자가없을경우() {
        assertSimpleTest(() -> {
            run("//7\\n7777");
            assertThat(output()).contains("결과 : 0");
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
    void 예외_테스트_소수사용_정수누락시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(".12,0.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_소수사용_소수누락시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2.,0.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_커스텀구분자문자사용_숫자누락시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\;;;;;;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_커스텀구분자미사용_숫자누락시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,::,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_커스텀구분자미사용_문자누락시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자0만입력시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_소수0만입력시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0.0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
