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
    void 예외_테스트2_마지막에구분자추가() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3_구분자추가형식엇나감() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4_기본구분자연속두개들어감() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트5_커스텀구분자연속두개들어감() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;a\n1;a2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 테스트케이스_구분자에n이들어가는경우(){
        assertSimpleTest(() -> {
            run("//;na\\n1a2");
            assertThat(output()).contains("결과 : 3");
        });
    }


    @Test
    void 테스트케이스1_많은구분자(){
        assertSimpleTest(() -> {
            run("//;naspqur\\n1a2p4q6:7;82");
            assertThat(output()).contains("결과 : 102");
        });
    }

    @Test
    void 테스트케이스2_매우큰수(){
        assertSimpleTest(() -> {
            run("//;na\\n111111111111111111111111111n222222222222222222222222222");
            assertThat(output()).contains("결과 : 333333333333333333333333333");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
