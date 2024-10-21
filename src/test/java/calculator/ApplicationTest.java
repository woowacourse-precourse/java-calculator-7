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
    void 정상적인_입력테스트() {
        assertSimpleTest(() -> {
            run("1,2;3,4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 쉼표만_표함된_경우_입력테스트() {
        assertSimpleTest(() -> {
            run("1,2,4,5");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 세미콜론만_표함된_경우_입력테스트() {
        assertSimpleTest(() -> {
            run("1;2;3;4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1/2/3/4"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈문자_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("\n"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수인_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("1,2;-3,4;5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_정상_입력_테스트(){
        assertSimpleTest(() -> {
            run("//*\\n1*2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자가_엾는_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("//\\n1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_숫자인_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("//3\\n1323334"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_아닌_다른_구분자를_사용할_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("//*\\n1;2;3;4"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_빈문자일_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("//*\\n"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_숫자가_음수일_경우_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(()-> runException("//*\\n1*-3*1*2"))
                .isInstanceOf(IllegalArgumentException.class)
        );    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
