package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 연속된_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//?\\n//|\\n1;2?3|4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자와_빈값이_섞여있는_경우() {
        assertSimpleTest(() -> {
            run("            1:      2,         3:                 4,           ");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 굉장히_큰_숫자를_계산하는_경우() {
        assertSimpleTest(() -> {
            run("100000000000000000000000000000,200000000000000000000000000000");
            assertThat(output()).contains("결과 : 300000000000000000000000000000");
        });
    }

    @Test
    void 구분자가_연속해서_있는_경우() {
        assertSimpleTest(() -> {
            run("//?\\n:::::1?????2,,,,,3???");
            assertThat(output()).contains("결과 : 6");
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
    void 커스텀_구분자가_문자열의_앞이아닌_다른곳에_위치하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3//?\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자 형식으로 변환할 수 없는 값입니다.")
        );
    }

    @Test
    void 등록하지_않은_커스텀_문자를_사용하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:3?4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("3?4은 숫자 형식으로 변환할 수 없는 값입니다.")
        );
    }

    @Test
    void 빈값을_입력하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("     "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("계산할 숫자를 입력하세요")
        );
    }

    @Test
    void 숫자가_아닌_형식을_입력하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("apple"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("apple은 숫자 형식으로 변환할 수 없는 값입니다.")
        );
    }

    @Test
    void 커스텀_구분자에_문자가_아닌_문자열을_사용하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//??\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자는 문자만 가능합니다.")
        );
    }

    @Test
    void 구분자만_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,:::::"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("계산할 숫자를 입력하세요")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
