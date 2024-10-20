package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void null_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run("    ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단일_숫자() {
        assertSimpleTest(() -> {
            run("7");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 쉼표_숫자() {
        assertSimpleTest(() -> {
            run("1,2,10");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 기본_구분자_숫자() {
        assertSimpleTest(() -> {
            run("1,2:10:42");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 기본_구분자_공백_숫자() {
        assertSimpleTest(() -> {
            run("1,2 : 10:42");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 기본_구분자_큰단위_숫자() {
        assertSimpleTest(() -> {
            run("1,100:200:1000");
            assertThat(output()).contains("결과 : 1301");
        });
    }
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");

            run("//;\\n1;2;7");
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
