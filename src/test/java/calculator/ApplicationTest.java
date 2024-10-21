package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 입력_없음() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자만_입력() {
        assertSimpleTest(() -> {
            run("4");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 콤마_구분자() {
        assertSimpleTest(() -> {
            run("1,2,4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 콜론_구분자() {
        assertSimpleTest(() -> {
            run("1:3:5");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 콤마_콜론_구분자() {
        assertSimpleTest(() -> {
            run("1,3:7");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 커스텀_콜론_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_콤마_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,9");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 문자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,t"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_누락() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1$2$3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1$2$3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}