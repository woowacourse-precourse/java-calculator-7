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

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class CustomDelimiterTests {
        @Test
        void 커스텀_구분자_사용() {
            assertSimpleTest(() -> {
                run("//;\\n1");
                assertThat(output()).contains("결과 : 1");
            });
        }

        @Test
        @DisplayName("커스텀 구분자로 덧셈")
        void 커스텀_구분자_테스트() {
            assertRandomUniqueNumberTest("//;\\n1;2;3", "6");
        }

        @Test
        @DisplayName("한글 커스텀 구분자로 덧셈")
        void 한글_커스텀_구분자_테스트() {
            assertRandomUniqueNumberTest("//가\\n1가2가3", "6");
        }

        @Test
        @DisplayName("이모지 커스텀 구분자로 덧셈")
        void 이모지_커스텀_구분자_테스트() {
            assertRandomUniqueNumberTest("//🍎\\n1🍎2🍎3", "6");
        }
    }

    @Nested
    @DisplayName("예외 상황 테스트")
    class ExceptionTests {
        @Test
        @DisplayName("음수 입력 시 예외 발생")
        void 예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-1,2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("음수는 허용되지 않습니다: -1")
            );
        }

        @Test
        @DisplayName("잘못된 숫자 형식 입력 시 예외 발생")
        void 잘못된_숫자_형식_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,a,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("잘못된 숫자 형식")
            );
        }

        @Test
        @DisplayName("최대값 초과 시 예외 발생")
        void 최대값_초과_예외_테스트() {
            String largeNumber = String.valueOf(Integer.MAX_VALUE + 1L);
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1," + largeNumber + ",3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력된 숫자가 허용 범위를 초과했습니다")
            );
        }

        @Test
        @DisplayName("공백만 있는 문자열 입력 시 예외 발생")
        void 공백_문자열_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("   "))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 문자열이 null이거나 비어 있습니다")
            );
        }

        @Test
        @DisplayName("커스텀 구분자 지정 후 \\n 없음")
        void 커스텀_구분자_후_개행_없음_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//;\n1;2;3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("커스텀 구분자 지정 후 \\n이 없습니다")
            );
        }

        @Test
        @DisplayName("여러 문자로 된 커스텀 구분자")
        void 여러_문자_커스텀_구분자_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//;;\\n1;;2;;3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("커스텀 구분자는 정확히 하나의 유니코드 문자여야 합니다")
            );
        }

        @Test
        @DisplayName("빈 커스텀 구분자")
        void 빈_커스텀_구분자_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//\\n1,2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("커스텀 구분자가 비어있습니다")
            );
        }
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
