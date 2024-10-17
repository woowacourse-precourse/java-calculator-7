package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run(" \t\f\r");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run(" \t");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void null_입력() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_입력_쉼표() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_입력_콜론() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_입력_쉼표_콜론_혼용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈문자열_숫자() {
        assertSimpleTest(() -> {
            run("1,,3");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 구분자_시작() {
        assertSimpleTest(() -> {
            run(",1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_끝() {
        assertSimpleTest(() -> {
            run("1:2:3:");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("1:a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("2147483647,1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("-1,1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void zero_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("0,1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
