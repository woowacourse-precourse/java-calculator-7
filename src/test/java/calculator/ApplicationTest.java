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
    void 기본_구분자_숫자_더하기() {
        assertSimpleTest(() -> {
            run("1,2,3:4:5,6");
            assertThat(output()).contains("결과 : 21");
        });

        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_숫자_더하기() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//a\\n1a2a3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//뷁\\n1뷁2뷁3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_모든_특수문자_사용_숫자_더하기() {
        String[] delimiters = {
                "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+",
                "[", "{", "]", "}", ";", "'", "\"", "<", ">", ".", "/", "?", "\\", "|"
        };

        for (String delimiter : delimiters) {
            String input = "//" + delimiter + "\\n1" + delimiter + "2" + delimiter + "3";
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 6");
            });
        }
    }

    @Test
    void 커스텀_구분자_알파벳_한글_사용_숫자_더하기() {
        assertSimpleTest(() -> {
            run("//abc\\n1a2b3c4");
            assertThat(output()).contains("결과 : 10");
        });

        assertSimpleTest(() -> {
            run("//가\\n1가2가3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_연속된_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1--2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n1:2##3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_등록되지_않은_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1'2:3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1[2]3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자열_앞뒤_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1,2,3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자를_구분자로_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//5\\n5,4,5,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
