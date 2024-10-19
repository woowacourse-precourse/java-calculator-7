package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 테스트")
class ApplicationTest extends NsTest {
    @Nested
    @DisplayName("기본 덧셈 테스트")
    class BasicAdditionTests {
        @Test
        @DisplayName("기본 구분자로 덧셈")
        void 기본_구분자_덧셈_테스트() {
            assertRandomUniqueNumberTest("1,2,3", "6");
        }

        @Test
        @DisplayName("단일 숫자 입력")
        void 단일_숫자_테스트() {
            assertRandomUniqueNumberTest("1", "1");
        }
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
                        .hasMessage("음수는 허용되지 않습니다: -1")
        );
    }

    private void assertRandomUniqueNumberTest(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
