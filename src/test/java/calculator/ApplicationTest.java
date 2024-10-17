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

}
