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
    void 커스텀_구분자_미입력() {
        assertSimpleTest(() -> {
            run("//\\n1,2,3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 커스텀_구분자_복수() {
        assertSimpleTest(() -> {
            run("//[]{}\\n1[7}9");
            assertThat(output()).contains("결과 : 17");
        });
    }
    @Test
    void 커스텀_구분자_알파벳() {
        assertSimpleTest(() -> {
            run("//AB\\n1A2B3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 커스텀_구분자_특수문자1() {
        assertSimpleTest(() -> {
            run("//`\\n1`2`3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 커스텀_구분자_특수문자2() {
        assertSimpleTest(() -> {
            run("//~\\n1~2~3");
            assertThat(output().contains("결과 : 6"));
        });
    }


    @Test
    void 기본입력() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 연속정규식입력() {
        assertSimpleTest(() -> {
            run("//;\\\\n1;2;3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 에외_테스트2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1,2,abc"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Test
    void 에외_테스트3() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;.\\n1,2;@3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Test
    void 에외_테스트4() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1, 2, 3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Test
    void 에외_테스트5() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1;2;3,|"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
