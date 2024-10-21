package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        for (String[] validInput : CUSTOM_VALID_INPUTS) {
            assertSimpleTest(() -> {
                run(validInput[0]);
                assertThat(output()).contains("결과 : " + validInput[1]);
            });
        }

    }

    private static final String[][] CUSTOM_VALID_INPUTS = {
            {"//;\\n1", "1"},
            {"//;\\n1", "1"},
            {"//S\\n1S2S3:4", "10"},
            {"//ST\\n1S2T3:4", "10"}
    };

    @Test
    void 커스텀_구분자_사용안함() {
        for (String[] validInput : ORIGIN_VALID_INPUTS) {
            assertSimpleTest(() -> {
                run(validInput[0]);
                assertThat(output()).contains("결과 : " + validInput[1]);
            });
        }

    }

    private static final String[][] ORIGIN_VALID_INPUTS = {
            {"1,2:3", "6"},
            {"1,2,3", "6"},
            {"", "0"},
            {"1,2", "3"},
            {"12,2:3", "17"},
    };


    @Test
    void 예외_테스트() {
        for (String invalidInput : INVALID_INPUTS) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(invalidInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    private static final String[] INVALID_INPUTS = {
            "-1,2,3",
            "//;\\1,2,3",
            "1,-2,3",
            "1,2,-3",
            "a,2,-3",
            "1,,2,-3",
            "aaa"
    };

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
