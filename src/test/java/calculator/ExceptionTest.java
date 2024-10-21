package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ExceptionTest extends NsTest {
    @Test
    void 구분자가_포함돼있지_않다면_예외_처리() {
        // when
        // given
        String testUserInput = "1234";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("구분자가 포함돼야합니다.");
        });
    }

    @Test
    void 마지막_문자가_숫자가_아니라면_예외_처리() {
        // when
        // given
        String testUserInput = "1,2,3,4,";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("마지막 문자는 숫자여야 합니다.");
        });
    }

    @Test
    void 커스텀_구분자_사이에_2개이상의_문자가_포함돼있을_경우_예외_처리() {
        // when
        // given
        String testUserInput = "//;;\\n1;2;3";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("커스텀 구분자 형식이 올바르지 않습니다.");
        });
    }

    @Test
    void 연속해서_구분자를_사용할_경우_예외_처리() {
        // when
        // given
        String testUserInput = "1,,2,3,4";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("연속된 구분자는 허용되지 않습니다.");
        });
    }

    @Test
    void 숫자0_이_포함된_경우_예외_처리() {
        // when
        // given
        String testUserInput = "1,2,0,4";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수 또는 0은 허용되지 않습니다");
        });
    }

    @Test
    void 음수가_포함된_경우_예외_처리() {
        // when
        // given
        String testUserInput = "1:-1:2:-4";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수 또는 0은 허용되지 않습니다");
        });
    }

    @Test
    void 숫자가_아닌_문자가_포함됐을_경우_예외_처리() {
        // when
        // given
        String testUserInput = "1,2,d,4";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다: d");
        });
    }

    @Test
    void 단일_숫자_최대값이_10억을_초과한다면_예외_처리() {
        // when
        // given
        String testUserInput = "10000000000,1";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자 최대값인 10억을 초과할 수 없습니다.");
        });
    }

    @Test
    void 더하고자하는_숫자_개수가_10개를_초과한다면_예외_처리() {
        // when
        // given
        String testUserInput = "1,2,3,4,5,6,7,8,9,10,11";

        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(testUserInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("10개 이상의 숫자를 더할 수 없습니다.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}


