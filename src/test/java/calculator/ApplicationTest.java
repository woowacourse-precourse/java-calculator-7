package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("쉼표와 콜론으로 구분된 문자열에서 숫자 추출")
    void 숫자_추출_테스트() {
        String input = "1,2,3";
        int[] result = Application.extractNumbers(input, Application.separators);
        assertThat(result).contains(1, 2, 3);
    }

    @Test
    @DisplayName("배열의 모든 숫자를 더함")
    void 더하는_기능_테스트() {
        int[] input = {1, 2, 3};
        int result = Application.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "커스텀 구분자: \"{0}\" -> 결과: {1}")
    @CsvSource({
            "'//;\\n1', 1",
            "'//.\\n1', 1",
            "'//\\t\\n1\\t2\\t3,4', 10"
    })
    @DisplayName("커스텀 구분자를 사용한 문자열 덧셈")
    void 커스텀_구분자_사용_테스트(String input, int expectedSum) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expectedSum);
        });
    }

    @ParameterizedTest(name = "잘못된 입력: \"{0}\"")
    @CsvSource({
            "'aks3lii1ndm'",
            "'1,,2,3'",
            "'//\\n1234'",
            "'//3\\n13233'"
    })
    @DisplayName("잘못된 형식의 문자열에 대한 예외 발생")
    void 형식에_맞지_않는_문자열_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("음수 포함 시 예외 발생")
    void 음수_포함_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 문자열 입력 시 결과는 0")
    void 빈문자열_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("출력 형식이 올바르게 표시됨")
    void 출력_형식_테스트() {
        assertSimpleTest(() -> {
            run("///\\n1/2,3:4");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
