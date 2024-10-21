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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_파이프() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_해시() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트_잘못된_구분자_연속() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_아닌_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 엣지케이스_선행_0() {
        assertSimpleTest(() -> {
            run("000,2,003");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 엣지케이스_공백_문자열() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("    "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 엣지케이스_공백_있는_숫자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,   2,  3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_쉼표_사용() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_콜론_사용() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
