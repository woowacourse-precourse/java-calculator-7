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
    void 숫자커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//1\\n214");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 매우_큰_수_사용() {
        assertSimpleTest(() -> {
            run("100000000000000000000,1");
            assertThat(output()).contains("결과 : 100000000000000000001");
        });
    }

    @Test
    void 커스텀_구분자_탭문자_사용() {
        assertSimpleTest(() -> {
            run("//\t\\n1\t2\t3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_캐리지리턴_사용() {
        assertSimpleTest(() -> {
            run("//\r\\n1\r2\r3");
            assertThat(output()).contains("결과 : 6");
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
    void 예외_테스트_잘못된_형식_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_커스텀구분자_개행문자_설정() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n\\n1\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_미설정_문자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//?\\n1!2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_매우_긴_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(
                        "1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890"
                                + ","
                                + "1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890"
                                + ","
                                + "1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
