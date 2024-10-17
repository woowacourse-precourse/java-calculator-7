package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 기본_구분자만_포함하고_있을_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("1,2,4:6,9");
            assertThat(output()).contains("결과 : 22");
        });
    }

    @Test
    void 커스텀_구분자를_포함하고_있을_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("//<>^\\n1,2,3:90<>^100");
            assertThat(output()).contains("결과 : 22");
        });
    }

    @Test
    void 구분자가_연속적으로_이어질_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("::1::");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자에_1에서_9까지의_숫자가_포함되어_있을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3)<\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_마침표_하나만으로_이루어져_있을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//.\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_무리수_기호를_포함하고_있을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//π\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_빈_문자열만으로_이루어져_있을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자와_무리수_기호_이외의_문자가_발견될_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//$\\n1*"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실수가_포함된_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("1:2,3.5643930:99987.1237894834126326312314");
            assertThat(output()).contains("결과 : 99993.6881825");
        });
    }

    @Test
    void 하나의_숫자_내_여러개의_마침표가_포함되어_있는_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3,4.5.6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 무리수_기호가_포함된_경우_결과를_소수점_10자리까지_반올림하여_출력한다() {
        assertSimpleTest(() -> {
            run("1,2,log2");
            assertThat(output()).contains("결과 : 3.3010299957");
        });
    }

    @Test
    void 무리수_기호에_배수를_사용할_경우_결과를_소수점_10자리까지_반올림하여_출력한다() {
        assertSimpleTest(() -> {
            run("1,2,2π");
            assertThat(output()).contains("결과 : 9.2831853072");
        });
    }

    @Test
    void 무리수_기호가_잘못_사용된_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,2√"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
