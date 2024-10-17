package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class ApplicationTest extends NsTest {

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @Test
        void 음수_입력시_예외를_발생시킨다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1:-2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("음수는 입력 불가합니다.")
            );
        }

        @Test
        void 연속되는_기본_구분자의_경우_예외를_발생시킨다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1::-2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("올바른 숫자 형식이 아닙니다.")
            );
        }

        @Test
        void 잘못된_형식의_커스텀_구분자의_경우_예외를_발생시킨다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//1:2:3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("올바른 형식으로 입력하세요.")
            );
        }
    }

    @Nested
    class 정상적인_구분자_테스트를_진행한다 {

        @Test
        void 기본_구분자_테스트를_진행한다() {
            assertSimpleTest(() -> {
                run("1,2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 커스텀_구분자_테스트를_진행한다() {
            assertSimpleTest(() -> {
                run("//;\\n1;2;3");
                assertThat(output()).contains("결과 : 6");
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
