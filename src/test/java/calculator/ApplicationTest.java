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

    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본구분자_정상_입력() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본구분자_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본구분자_사이_숫자_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:d,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본구분자_잘못된_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1-3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본구분자_두개_연속_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1::3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_정상_입력() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_끝_잘못_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\m1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_문자가_아닌_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_숫자인_경우_입력() {
        assertSimpleTest(() -> {
            run("//9\\n19293");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_숫자인_경우_연속입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//9\\n19993"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_공백_입력() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_한자리수_이상_입력() {
        assertSimpleTest(() -> {
            run("10,20:33");
            assertThat(output()).contains("결과 : 63");
        });
    }

    @Test
    void 커스텀_한자리수_이상_입력() {
        assertSimpleTest(() -> {
            run("//;\\n10;20;33");
            assertThat(output()).contains("결과 : 63");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
