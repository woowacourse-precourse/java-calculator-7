package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    // 기본 구분자 테스트
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

    @Test
    void float_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("1.1,1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 아주_큰_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("10000000000000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    // 커스텀 구분자 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_복수() {
        assertSimpleTest(() -> {
            run("//;\\n1;1;1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 문자열_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("//;;\\n1;1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 정규표현식_기호_포함_마침표() {
        assertSimpleTest(() -> {
            run("//.\\n10.10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_별표() {
        assertSimpleTest(() -> {
            run("//*\\n10*10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_더하기() {
        assertSimpleTest(() -> {
            run("//+\\n10+10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_물음표() {
        assertSimpleTest(() -> {
            run("//?\\n10?10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_케럿() {
        assertSimpleTest(() -> {
            run("//^\\n10^10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_달러() {
        assertSimpleTest(() -> {
            run("//$\\n10$10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_OR() {
        assertSimpleTest(() -> {
            run("//.\\n10.10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_역슬래시() {
        assertSimpleTest(() -> {
            run("//|\\n10|10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_여는괄호() {
        assertSimpleTest(() -> {
            run("//(\\n10(10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 정규표현식_기호_포함_닫는괄호() {
        assertSimpleTest(() -> {
            run("//)\\n10)10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
