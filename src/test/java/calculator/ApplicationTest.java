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
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 엔터_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 탭_입력() {
        assertSimpleTest(() -> {
            run("\t");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단일_숫자_입력() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 연속된_숫자_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 연속된_숫자_입력_공백_포함() {
        assertSimpleTest(() -> {
            run(" 123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 기본_구분자_쉼표_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_쉼표_사용_공백_포함() {
        assertSimpleTest(() -> {
            run("1, 2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_콜론_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_쉼표_콜론_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_파이프_사용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_마이너스_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_음수_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_연속된_숫자_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_문자_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_마이너스_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n-1-2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n11213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_정의_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_기본_구분자_혼용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_커스텀_구분자_잘못된_위치() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
