package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.utils.Parser;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    Parser parser = new Parser();

    @Test
    void 정수와_실수가_포함된_계산일시_실수를_출력해야한다() {
        assertSimpleTest(() -> {
            run("1,2.5,4,10.7");
            assertThat(output()).contains("결과 : 18.2");
        });
    }

    @Test
    void 숫자만_입력한_경우_그대로_반환되어야한다() {
        assertSimpleTest(() -> {
            run("1234567");
            assertThat(output()).contains("결과 : 1234567");
        });
    }

    @Test
    void 정수의_덧셈인_경우_정수_결과를_출력해야한다() {
        assertSimpleTest(() -> {
            run("1,2,5:5,10");
            assertThat(output()).contains("결과 : 23");
        });
    }

    @Test
    void 실수의_덧셈인_경우_실수_결과를_출력해야한다() {
        assertSimpleTest(() -> {
            run("3,9:5.4:7.2,10");
            assertThat(output()).contains("결과 : 34.6");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//t\\n1t2t3t4", "//,\\n1,2,3,4"})
    void 커스텀_구분자_사용시에도_정수_덧셈_기능을_수행가능해야한다(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 10");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//t\\n1.2t2.3t3.4t4.5", "//,\\n1.2,2.3,3.4,4.5"})
    void 커스텀_구분자_사용시에도_실수_덧셈_기능을_수행가능해야한다(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 11.4");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//^\\n5^10^15^20",
            "//$\\n5$10$15$20",
            "//+\\n5+10+15+20",
            "//.\\n5.10.15.20",
            "//?\\n5?10?15?20",
            "//|\\n5|10|15|20",
            "//*\\n5*10*15*20",
            "//!\\n5!10!15!20"
    })
    void 커스텀_구분자가_정규표현식_메타문자로_인식되어선_안된다(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 50");
        });
    }

    @Test
    void 빈_문자열을_입력하면_0이_반환되어야한다() {
        List<Number> result = parser.parse("");
        Number expected = 0;
        assertThat(result.getFirst()).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자_사용시_다른_구분자를_사용하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> parser.parse("//,\\n1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용선언시_커스텀_구분자를_포함해야한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> parser.parse("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_지정없이_커스텀_구분자_사용시_예외가_발생해야한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> parser.parse("1.2.3"))
                        .isInstanceOf(IllegalArgumentException.class)
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
