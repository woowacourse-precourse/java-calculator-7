package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자를_설정_후_맨_앞에_사용() {
        assertSimpleTest(() -> {
            run("//;;\\n;;1;;2;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자를_설정_후_맨_뒤에_사용() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2,3;;");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자를_설정_후_맨_앞과_뒤에_사용() {
        assertSimpleTest(() -> {
            run("//;;\\n;;1:2;;3;;");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자를_일반구분자와_붙여서_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;;\\n;:1:2;;3;;"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_비정상적_시도() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/\\123:123"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 공백_구분자() {
        assertSimpleTest(() -> {
            run("// \\n11,2 3:4");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 커스텀_아닌_구분자_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("// \\n11,2 3;4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 정상적인_입력() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 문자열_처음에_구분자() {
        assertSimpleTest(() -> {
            run(",1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_두번_테스트_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2::3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 슬래시_n을_구분자로() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n\\n123\\n123"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 슬래시_n을_구분자로_X2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n\\n\\n123\\n\\n123"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_포함_구분자() {
        assertSimpleTest(() -> {
            run("// ?\\n11,2 ?3:4");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 이스케이프를_구분자로() {
        assertSimpleTest(() -> {
            run("//?\\n123?123");
            assertThat(output()).contains("결과 : 246");
        });
    }

    @Test
    void 이스케이프를_구분자로_X2() {
        assertSimpleTest(() -> {
            run("//??\\n123??123??123");
            assertThat(output()).contains("결과 : 369");
        });
    }

    @Test
    void 음수를_포함한_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 매우_큰_숫자_입력() {
        assertSimpleTest(() -> {
            run("1000000,2000000,3000000");
            assertThat(output()).contains("결과 : 6000000");
        });
    }

    @Test
    void 공백만_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 특수문자_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[*][*]\\n1*2*3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 구분자로_빈_문자열_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자만_연속으로_입력() {
        assertSimpleTest(() -> {
            run("123456789");
            assertThat(output()).contains("결과 : 123456789");
        });
    }

    @Test
    void 여러_줄의_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3\\n4,5:6\\n7,8:9"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 구분자_없는_연속된_공백_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2 3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 매우_긴_입력() {
        assertSimpleTest(() -> {
            run("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
            assertThat(output()).contains("결과 : 30");
        });
    }

    @Test
    void 소수_입력_의도_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.5,2.3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 소수_입력_의도_예외2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("// \n1.5:2.5:2.3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 빈문자열_사이_숫자() {
        assertSimpleTest(() -> {
            run("   1:2:3:4:   ");
            assertThat(output()).contains("결과 : 10");
        });
    }
}
