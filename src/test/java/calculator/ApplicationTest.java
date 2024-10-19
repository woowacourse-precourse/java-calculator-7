package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest extends NsTest {

    private Adder adder;
    private Formatter formatter;

    static Stream<String> invalidDelimiterInputs() {
        return Stream.of(
                "/;\\n1,2", "/;\\n1,2", ";\\n1,2", "\\n1,2",
                "//;\n1,2", "//;n1,2", "//;\\1,2",
                "/;\n1,2", "/;n1,2", "/;\\1,2", ";\n1,2", ";n1,2", ";\\1,2", "\n1,2", "n1,2", "\\1,2"
        );
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
        );
    }

    /**
     * 추가한 테스트
     */
    @Test
    @DisplayName("0을 입력하는 경우 예외가 발생해야 한다.")
    void 사용자_입력_부호_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사용자 입력은 양수여야 합니다.")
        );
    }

    @Test
    @DisplayName("기본 및 커스텀 구분자 및 숫자를 제외한 문자를 입력하는 경우 예외가 발생해야 한다.")
    void 사용자_입력_문자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3;!@#$%^&*()"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사용자 입력은 기본 및 커스텀 구분자 및 숫자를 제외한 문자가 포함될 수 없습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,3!@#$%^&*()"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사용자 입력은 기본 및 커스텀 구분자 및 숫자를 제외한 문자가 포함될 수 없습니다.")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidDelimiterInputs")
    @DisplayName("커스텀 구분자 설정 양식이 올바르지 않은 경우 예외가 발생해야 한다")
    void 커스텀_구분자_설정_테스트(String input) {
        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자 설정 양식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 설정 양식 내에 1개의 문자가 존재하지 않는 경우 예외가 발생해야 한다. 이때 공백 1칸도 1개의 문자로 간주한다.")
    void 커스텀_구분자_미입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자 내에는 1개의 문자가 존재해야 합니다.")
        );

        assertSimpleTest(() -> {
            run("// \\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 사용자 입력에서 숫자만을 추출한다")
    void 기본_구분자_숫자_추출_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "1,2,,3";

            // when
            int[] formatedNums = formatter.formatInput(input);

            // then
            assertThat(formatedNums.length).isEqualTo(4);
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 사용자 입력에서 숫자만을 추출한다")
    void 커스텀_구분자_숫자_추출_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n1;2;,3";

            // when
            int[] formatedNums = formatter.formatInput(input);

            // then
            assertThat(formatedNums.length).isEqualTo(4);
        });
    }

    @Test
    @DisplayName("사용자 입력에서 올바르게 추출된 숫자들을 모두 더한다")
    void 숫자_덧셈_테스트() {
        assertSimpleTest(() -> {
            // given
            int[] nums = {1, 2, 3};

            // when
            int result = adder.addNum(nums);

            // then
            assertThat(result).isEqualTo(1 + 2 + 3);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
