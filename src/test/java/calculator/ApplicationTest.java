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
    void 리터럴_대신_엔터() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//$%^\\n1$2%3^4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자_중복_사용() {
        assertSimpleTest(() -> {
            run("//$\\n$$$$1$$$2$$");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void int_초과값_사용() {
        assertSimpleTest(() -> {
            run("2147483647,1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void 숫자를_구분자로_사용_리터럴() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n21314"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자를_구분자로_사용_엔터() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\n21314"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 메타문자_처리() {
        assertSimpleTest(() -> {
            run("//\\\\n\\1\\2\\3\\\\45,,,,12");
            assertThat(output()).contains("결과 : 63");
        });
    }

    @Test
    void 한글_구분자() {
        assertSimpleTest(() -> {
            run("//우테코화이팅!\\n1우2테3코4화이팅!!!!!!!!!!!!!!");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 마이너스_구분자() {
        assertSimpleTest(() -> {
            run("//-\\n---1--2-3-4---");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
