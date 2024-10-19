
package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void Input_음수판단(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-15:523"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /*
    @Test
    void 구분된_숫자_실수판별_성공(){
        assertSimpleTest(() ->{
            run("//*\\n37*38.7:34.5");
            assertThat(output()).contains("[37, 38.7, 34.5]");
        });
    }
    @Test
    void 구분된_숫자_실수판별_실패1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*\\n37*38..7:34.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분된_숫자_실수판별_실패2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*\\n37*.38.7:34.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분된_숫자_실수판별_실패3(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*\\n37*.38.7:34.5."))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void Input_구분자_구분(){
        assertSimpleTest(() ->{
            run("//#\\n39:24#72");
            assertThat(output()).contains("[39, 24, 72]");
        });
    }

    @Test
    void Input_구분자_구분_특수문자(){
        assertSimpleTest(() ->{
            run("//+\\n21+23+52");
            assertThat(output()).contains("[21, 23, 52]");
        });
    }
    @Test
    void Input_커스텀구분자_중간(){
        assertSimpleTest(() ->{
            run("14$23$//$\\n72");
            assertThat(output()).contains("[14, 23, 72]");
        });
    }

    @Test
    void Input_구분_문자포함(){
        assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("1sf4$2@#3$//$\\n72"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Input_커스텀구문자_추가1(){
        assertSimpleTest(() ->{
            run("//#\\n3924");
            assertThat(output()).contains("[,, :, #]");
            assertThat(output()).contains("3924");
        });
    }
    @Test
    void Input_커스텀구문자_추가2(){
        assertSimpleTest(() ->{
            run("72//#\\n28");
            assertThat(output()).contains("[,, :, #]");
            assertThat(output()).contains("7228");
        });
    }
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
    */
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
