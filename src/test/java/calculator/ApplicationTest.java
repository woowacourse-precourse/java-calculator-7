package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_쉼표와_콜론() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_마이너스() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 잘못된_구분자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2:3;4"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 연속된_구분자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,,2::3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_숫자_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//1\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test   
    void 커스텀_구분자_문자_시작_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//-\\n-1,2-3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Test
    void 커스텀_구분자_백틱() {
        assertSimpleTest(() -> {
            run("//`\\n1`2`3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_물결표() {
        assertSimpleTest(() -> {
            run("//~\\n1~2~3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_별표() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_느낌표() {
        assertSimpleTest(() -> {
            run("//!\\n1!2!3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_골뱅이() {
        assertSimpleTest(() -> {
            run("//@\\n1@2@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_샵() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_달러() {
        assertSimpleTest(() -> {
            run("//$\\n1$2$3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_퍼센트() {
        assertSimpleTest(() -> {
            run("//%\\n1%2%3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_캐럿() {
        assertSimpleTest(() -> {
            run("//^\\n1^2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_앤드() {
        assertSimpleTest(() -> {
            run("//&\\n1&2&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_언더스코어() {
        assertSimpleTest(() -> {
            run("//_\\n1_2_3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_등호() {
        assertSimpleTest(() -> {
            run("//=\\n1=2=3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_플러스() {
        assertSimpleTest(() -> {
            run("//+\\n1+2+3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_물음표() {
        assertSimpleTest(() -> {
            run("//?\\n1?2?3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_슬래시() {
        assertSimpleTest(() -> {
            run("///\\n1/2/3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_백슬래시() {
        assertSimpleTest(() -> {
            run("//\\\\\\n1\\2\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Test
    void 커스텀_구분자_콜론() {
        assertSimpleTest(() -> {
            run("//:\\n1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_하이픈() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_쉼표() {
        assertSimpleTest(() -> {
            run("//,\\n1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_괄호() {
        assertSimpleTest(() -> {
            run("//(\\n1(2(3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_대괄호() {
        assertSimpleTest(() -> {
            run("//[\\n1[2[3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_중괄호() {
        assertSimpleTest(() -> {
            run("//{\\n1{2{3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_파이프() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_틸드() {
        assertSimpleTest(() -> {
            run("//~\\n1~2~3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
