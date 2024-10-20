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
    void 시작_문구_출력() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
        });
    }

    @Test
    void 결과_문구_출력() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과  : ");
        });
    }

    @Test
    void 무입력_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단순_숫자_입력() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 일반_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1:2,3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_일반_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//?\\n1:2?3?4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 숫자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//3\\n13234353");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 공백_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3  5,6");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 음수_연산_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2:-3:-4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 음수_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3-5,6:7");
            assertThat(output()).contains("결과 : 24");
        });
    }

    @Test
    void 여러_자릿수_입력() {
        assertSimpleTest(() -> {
            run("11:22,33:44");
            assertThat(output()).contains("결과 : 110");
        });
    }

    @Test
    void 큰_숫자_입력() {
        assertSimpleTest(() -> {
            run("1000000000000:2000000000000");
            assertThat(output()).contains("결과 : 300000000000");
        });
    }

    @Test
    void 플러스_기호_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("+1,+2:+3:+4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 잘못된_커스텀_구분자_위치() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2//?\\n3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 콜론_커스텀_구분자_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//:\\n1:2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 쉼표_커스텀_구분자_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//,\\n1:2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 문자열_커스텀_구분자_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,3?4?5:6"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자가_아닌_문자_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//?!\\n1:2,3?!5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 공백_사용_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1, 2, 3, 4: 5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 연속된_구분자의_입력() {
        assertSimpleTest(() -> {
            run("1:,2,:3:,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_잘못된_위치() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("?//\\n1,2,3?4:5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
