package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열을_입력하면_0을_반환() {
        assertSimpleTest(() -> {
            //given
            String input = "\n";
            //when
            run(input);
            //then
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_콜론_사용() {
        assertSimpleTest(() -> {
            //given
            String input = "1:2:3";
            //when
            run(input);
            //then
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_쉼표_사용() {
        assertSimpleTest(() -> {
            //given
            String input = "1,2,3";
            //when
            run(input);
            //then
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            //given
            String input = "//;\\n1;2;3";
            //when
            run(input);
            //then
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_결합_사용() {
        assertSimpleTest(() -> {
            //given
            String input = "//;\\n1;2,3:4";
            //when
            run(input);
            //then
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 잘못된_구분자_입력시_예외_처리() {
        assertThatThrownBy(() -> {
            //given
            Calculator calculator = new Calculator();
            String input = "//;\n1;2,a";
            //when
            calculator.add(input);
            //then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 커스텀 구분자 형식입니다");
    }

    @Test
    void 문자_입력_예외_처리() {
        assertThatThrownBy(() -> {
            //given
            Calculator calculator = new Calculator();
            String input = "//;\\n1;2,a";
            //when
            calculator.add(input);
            //then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다");
    }

    @Test
    void 음수_입력_예외_처리() {
        assertThatThrownBy(() -> {
            //given
            Calculator calculator = new Calculator();
            String input = "//;\\n1;2,-3";
            //when
            calculator.add(input);
            //then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 음수입니다");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
