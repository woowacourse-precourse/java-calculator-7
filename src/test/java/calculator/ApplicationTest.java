package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 커스텀_구분자_사용_정상() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_정상1_땀사용() {
        assertSimpleTest(() -> {
            run("//;\\n3;4;5");
            assertThat(output()).contains("결과 : 12");
        });
    }
    @Test
    void 커스텀_정상2() {
        assertSimpleTest(() -> {
            run("//.\\n3.4.5");
            assertThat(output()).contains("결과 : 12");
        });
    }
    @Test
    void 커스텀_정상3() {
        assertSimpleTest(() -> {
            run("//$\\n3$4$5");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 커스텀_정상4_백슬래시() {
        assertSimpleTest(() -> {
            run("//\\\\n3\\4\\5");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3^4^5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3k4k5k"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 구분자_두개_겹쳐서입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3,,4::5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 난데없는_구분자_두개가_겹쳐서_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3^^4^^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_아닌게_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("k:5:1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 음수가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 커스텀_구분자_양식이_틀림1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n3;4;5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_양식이_틀림2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n3;4;5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 중간에_공백이_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4 5,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백이랑_문자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4 k"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
