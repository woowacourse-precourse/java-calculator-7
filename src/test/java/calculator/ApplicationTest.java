package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.ParsingInputString;
import calculator.model.InputString;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void parsingInputTest() {
        //given
        InputString inputString = new InputString();
        inputString.setInput("12,3:4&6");
        inputString.setCustomChar('&');

        //when
        ParsingInputString parsingInputString = new ParsingInputString(inputString);
        List<Integer> integers = parsingInputString.parsingInput();

        //then
        assertThat(integers).isEqualTo(List.of(12, 3, 4, 6));
        assertThat(inputString.getNumberList()).isEqualTo(List.of(12, 3, 4, 6));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
