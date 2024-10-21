package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1:2,3,4,a"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_사용_INTEGER_MAX_초과한_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,3,4,2147483648"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_사용_INTEGER_MAX_경우() {
        assertSimpleTest(() -> {
            run("1,2147483646");
            assertThat(output()).contains("결과 : 2147483647");
        });
    }

    @Test
    void 기본_구분자_사용_전부_0인_경우() {
        assertSimpleTest(() -> {
            run("0,0,0,0,0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용_음수_포함() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자가_표현식_맨_앞에_오는_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자가_표현식_맨_뒤에_오는_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,3,"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 표현식_맨_뒤에_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,3,4a"))
                    .isInstanceOf(IllegalArgumentException.class);
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
