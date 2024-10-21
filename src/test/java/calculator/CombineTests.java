package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CombineTests extends NsTest {

    @Test
    void useCustomSeparator() {
        assertSimpleTest(() -> {
            run("//;\\n1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void useCommaSeparator() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void useColonSeparator() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void useMixSeparator_CommaColon() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void useMixSeparator_CustomCommaColon() {
        assertSimpleTest(() -> {
            run("//;\\n1:2,3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void blankInput() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void contains0AtFrontInput() {
        assertSimpleTest(() -> {
            run("1:002:03");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_minusInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_useCustomSeparatorByNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_strangeInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2:d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
