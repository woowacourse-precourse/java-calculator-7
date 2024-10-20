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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 추가 test 사항

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_연속_입력() {
        assertSimpleTest(() -> {
            run("1::2,,3,::4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 단일_양수_입력() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 한_자리_이상의_숫자_입력() {
        assertSimpleTest(() -> {
            run("10,5:201");
            assertThat(output()).contains("결과 : 216");
        });
    }

    @Test
    void 정해진_구분자_이외의_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}