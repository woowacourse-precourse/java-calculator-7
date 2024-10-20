package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 수가_하나만_입력() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 실수_입력() {
        assertSimpleTest(() -> {
            run("1,2.2");
            assertThat(output()).contains("결과 : 3.2");
        });
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수_및_기본_구분자와_커스텀_구분자_혼합_사용() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;2,-300"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_사용이_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_양수도_음수도_아닌_정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
