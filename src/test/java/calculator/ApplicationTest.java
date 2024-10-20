package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Nested
    class CalculatorTests {

        @Test
        void 커스텀_구분자_사용() {
            assertSimpleTest(() -> {
                run("//;\n1;2;3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 예외_테스트() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> run("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
            });
        }

        @Test
        void 기본_구분자_사용() {
            assertSimpleTest(() -> {
                run("1,2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 공백_문자열_입력() {
            assertSimpleTest(() -> {
                run("");
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Override
        public void runMain() {
            Application.main(new String[]{});
        }
    }
}
