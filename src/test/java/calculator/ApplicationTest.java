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
    void 커스텀_구분자_지정만_한_경우() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 공백을_포함하는_입력값1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\\n1;2 "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 공백을_포함하는_입력값2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\\n 1;2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자가_한개() {
        assertSimpleTest(() -> {
            run("2");
            assertThat((output()).contains("결과 : 2"));
        });
    }

    @Test
    void 커스텀_구분자가_제대로_주어질때() {
        assertSimpleTest(() -> {
            run("///\\n1/3/4");
            assertThat((output()).contains("결과 : 8"));
        });
    }

    @Test
    void 숫자가_한개2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("0"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자형태가_잘못된_경우1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("0123"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자형태가_잘못된_경우2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\\n012;24;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_이스케이프_문자X() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_형식이_아닌_경우1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run(";\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_형식이_아닌_경우2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_형식이_아닌_경우3() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("///^\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_형식이_아닌_경우4() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_숫자인_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//3\\n333333"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_1개가_아닌_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//^^\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자_이외에_문자가_들어간_경우1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,3;4:5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Test
    void 구분자_이외에_문자가_들어간_경우2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1;2;3;4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자_이외에_문자가_들어간_경우3() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//^\\n1,3^4:5n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자를_구분하지_못하는_구분자의_경우1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run(",1,34:5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자를_구분하지_못하는_구분자의_경우2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,34:5:"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자가_연속으로_입력된_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,3::4:5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
