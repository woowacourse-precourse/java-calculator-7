package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 정상_빈_문자열_입력_널문자() {
        assertSimpleTest(() -> {
            run("\0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정상_빈_문자열_입력_개행문자() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정상_디폴트_구분자_단일_정수값() {
        assertSimpleTest(() -> {
            run("7");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 정상_디폴트_구분자_단일_실수값() {
        assertSimpleTest(() -> {
            run("7.15");
            assertThat(output()).contains("결과 : 7.15");
        });
    }

    @Test
    void 정상_디폴트_구분자_복수_실수값() {
        assertSimpleTest(() -> {
            run("1.2:2.3");
            assertThat(output()).contains("결과 : 3.5");
        });
    }

    @Test
    void 정상_디폴트_구분자_단일_구분자() {
        assertSimpleTest(() -> {
            run("1,");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 정상_디폴트_구분자_혼합_구분자() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 정상_커스텀_구분자_빈_문자열() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정상_커스텀_구분자_미사용_정수값() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 정상_커스텀_구분자_미사용_실수값() {
        assertSimpleTest(() -> {
            run("//;\\n1.15");
            assertThat(output()).contains("결과 : 1.15");
        });
    }

    @Test
    void 정상_커스텀_구분자_단일_정수값() {
        assertSimpleTest(() -> {
            run("//!\\n1!");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 정상_커스텀_구분자_단일_실수값() {
        assertSimpleTest(() -> {
            run("//;\\n1.15;");
            assertThat(output()).contains("결과 : 1.15");
        });
    }

    @Test
    void 정상_커스텀_구분자_복수_실수깂() {
        assertSimpleTest(() -> {
            run("//;\\n1;4.2");
            assertThat(output()).contains("결과 : 5.2");
        });
    }

    @Test
    void 정상_커스텀_구분자_특수기호() {
        assertSimpleTest(() -> {
            run("//(\\n1(2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_커스텀_구분자_한글기호() {
        assertSimpleTest(() -> {
            run("//ㅎ\\n1ㅎ2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_커스텀_구분자_문장부호() {
        assertSimpleTest(() -> {
            run("//\"\\n1\"2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_커스텀_구분자_음수부호() {
        assertSimpleTest(() -> {
            run("//-\\n1-2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_커스텀_구분자_소수점() {
        assertSimpleTest(() -> {
            run("//.\\n1.2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_커스텀_구분자_공백문자() {
        assertSimpleTest(() -> {
            run("// \\n1 2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 예외_빈_문자열_입력_탭문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\t"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_빈_문자열_입력_공백문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_디폴트_구분자_음수값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_디폴트_구분자_미사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_문자혼용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;&2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_숫자사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//7\n17273"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_형식_시작_미준수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("&\n1&2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_형식_마감_미준수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&1&2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}