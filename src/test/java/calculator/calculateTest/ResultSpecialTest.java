package calculator.calculateTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ResultSpecialTest extends NsTest {

    @Test
    void 백슬래시_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 다중_백슬래시_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\\\\\n1\\\\2\\\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 백슬래시_문자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\x\\n1\\x2\\x3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 작은_따옴표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//'\\n1'2'3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 큰_따옴표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\"\\n1\"2\"3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 백슬래시_슬래시_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\/\\n1\\/2\\/3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 괄호_열기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//(\\n1(2(3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 괄호_닫기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//)\\n1)2)3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 백슬래시_앞_괄호_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\(\\n1\\(2\\(3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 백슬래시_뒤_괄호_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\)\\n1\\)2\\)3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 캐럿_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//^\\n1^2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 느낌표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//!\\n1!2!3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 골뱅이_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//@\\n1@2@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 샵_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 달러_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//$\\n1$2$3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 퍼센트_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//%\\n1%2%3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void AND_연산자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//&\\n1&2&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 별표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 바_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 언더_바_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//_\\n1_2_3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 플러스_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//+\\n1+2+3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 등호_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//=\\n1=2=3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 강세표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//`\\n1`2`3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 물결_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//~\\n1~2~3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void OR_연산자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 앞_중괄호_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//{\\n1{2{3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 뒤_중괄호_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//}\\n1}2}3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 거듭_인용표_열기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//<\\n1<2<3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 거듭_인용표_닫기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//>\\n1>2>3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 대괄호_열기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//[\\n1[2[3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 대괄호_닫기_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//]\\n1]2]3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 세미콜론_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
