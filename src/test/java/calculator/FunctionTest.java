package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FunctionTest extends NsTest {

    @Test
    void 계산_테스트_통과_1() {
        assertSimpleTest(() -> {
            run("1,2:3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 계산_테스트_통과_2() {
        assertSimpleTest(() -> {
            run("1,2:3,4:5:::");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 계산_테스트_통과_3() {
        assertSimpleTest(() -> {
            run(",:,10,20,:,:30,40:50:::");
            assertThat(output()).contains("결과 : 150");
        });
    }

    @Disabled
    @Test
    void 계산_테스트_통과_4() {
        assertSimpleTest(() -> {
            run(new String(""));
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 계산_테스트_통과_5() {
        assertSimpleTest(() -> {
            run(",:,10,20,:,:30,40:50:::");
            assertThat(output()).contains("결과 : 150");
        });
    }

    @Test
    void 계산_테스트_통과_6() {
        assertSimpleTest(() -> {
            run("::::");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 계산_테스트_통과_7() {
        assertSimpleTest(() -> {
            run("1000000000,200000000,30000000,4000000,567890");
            assertThat(output()).contains("결과 : 1234567890");
        });
    }

    @Test
    void 계산_테스트_예외_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1*2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2*,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("*"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(": :"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트_예외_7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000000000000,20000000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_통과_1() {
        assertSimpleTest(() -> {
            run("//*\\n1*2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_테스트_통과_2() {
        assertSimpleTest(() -> {
            run("//(*)\\n1(*)2(*)3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_테스트_통과_3() {
        assertSimpleTest(() -> {
            run("///\\n1/2/3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_테스트_통과_4() {
        assertSimpleTest(() -> {
            run("//  \\n1  2    3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_테스트_예외_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_예외_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_예외_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^-^\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_예외_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_예외_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//  \\n1 2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_테스트_예외_6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//**1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
