package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본테스트_1() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본테스트_2() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 일반_구분자_혼용_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
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
    void 커스텀_구분자_일반_구분자_혼용_사용() {
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
    void 구분자_연속_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1::3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_연속_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;;1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공란_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_공란_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_마이너스_입력() {
        assertSimpleTest(() -> {
            run("//-\\n1-1");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 커스텀_구분자_마이너스_입력_예외_케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1--1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_끝_위치_예외_케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 두_문자_이상_커스텀_구분자_설정() {
        assertSimpleTest(() -> {
            run("//-;\\n1-2;3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
