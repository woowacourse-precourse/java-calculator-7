package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void PlainCalculation1() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void PlainCalculation3() {
        assertSimpleTest(() -> {
            run("100;200;300;400;5000");
            assertThat(output()).contains("결과 : 6000");
        });
    }

    @Test
    void CustomSelector1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void CustomSelector2() {
        assertSimpleTest(() -> {
            run("//^\\n1^2;3^4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void Exception_UnacceptableValue1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableValue2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10000000000,10000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableValue3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000,1000000000,1000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableValue4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3,2,,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableValue5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10,5,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableValue6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(".30,20,10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void Exception_UnacceptableCustomSelector1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\n1,2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableCustomSelector2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//5\\n1,253"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableCustomSelector3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^^\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableCustomSelector4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^$\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableCustomSelector5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///^\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_UnacceptableCustomSelector6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
