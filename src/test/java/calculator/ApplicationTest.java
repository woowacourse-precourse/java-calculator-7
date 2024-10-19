
package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
    /*
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
