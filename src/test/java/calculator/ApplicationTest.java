package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

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

    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2:7", "12,3,2", "13:43,54"})
    void 기본구분자_정상_입력(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1:-3,4", "1,-4,-2"})
    void 기본구분자_음수_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:d,4", "f,3,s", "d,2:3"})
    void 기본구분자_사이_숫자_아닌_경우(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1-3:4", "1;6;8", "1:4;3"})
    void 기본구분자_잘못된_사용(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1::3:4", "2,,4::5", "2,,,,,,3:4", "1:2:3,,,,:::5"})
    void 기본구분자_두개_연속_사용(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//d\\n1d2d3", "//9\\n19293", "//2\\n1125523"})
    void 커스텀구분자_정상_입력(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\m1;2;3", "//c\\2,3:4", "//9\n19293"})
    void 커스텀구분자_끝_잘못_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;;\\n1;2;3", "//asd\\n1asd2asd3"})
    void 커스텀구분자_문자가_아닌_문자열_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//9\\n19993", "//2\\n1229,3"})
    void 커스텀구분자_숫자인_경우_연속입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_공백_입력() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"146,312,123", "31235:3122,123"})
    void 기본_한자리수_이상_입력(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n10;20;33", "//7\\n14723746"})
    void 커스텀_한자리수_이상_입력(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : ");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
