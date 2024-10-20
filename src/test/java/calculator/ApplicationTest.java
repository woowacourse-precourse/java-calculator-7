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

    // 정상 test 케이스
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
    void 커스텀_구분자가_공백() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자만_입력() {
        assertSimpleTest(() -> {
            run(",");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 예외 테스트 케이스
    @Test
    void 기본_구분자_외의_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자와_커스텀_구분자_이외의_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\n1b2a3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//AW\\n2AW3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_마이너스_기호() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}