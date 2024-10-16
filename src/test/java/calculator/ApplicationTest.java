package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.CalculateIntegerList;
import calculator.controller.ParsingInputString;
import calculator.model.InputString;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("커스텀 문자 파싱을 확인한다.")
    void parsingInputTest() {
        //given
        InputString inputString = new InputString("12,3:4&6");
        inputString.setCustomChar('&');

        //when
        ParsingInputString parsingInputString = new ParsingInputString(inputString);
        List<Integer> integers = parsingInputString.parsingInput();

        //then
        assertThat(integers).isEqualTo(List.of(12, 3, 4, 6));
        assertThat(inputString.getNumberList()).isEqualTo(List.of(12, 3, 4, 6));
    }

    @Test
    @DisplayName("계산 메서드의 동작을 확인한다.")
    void calculateTest() {
        //given
        InputString inputString = new InputString("1,2,3:4");
        inputString.setNumberList(List.of(1, 2, 3, 4));

        //when
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList(inputString);
        int calculateResult = calculateIntegerList.calculate();

        //then
        assertThat(calculateResult).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자 파싱 메서드를 확인한다.")
    void findCustomTest() {
        //given
        InputString inputString = new InputString("//;\\n1,2,3:4;9");

        //when
        ParsingInputString parsingInputString = new ParsingInputString(inputString);

        //then
        parsingInputString.findCustomChar();
        assertThat(inputString.getCustomChar()).isEqualTo(';');
    }

    @Test
    @DisplayName("특정 케이스를 확인한다.")
    void edgeCaseTest() {
        //given
        InputString inputString1 = new InputString("//\\n");
        ParsingInputString parsingInputString1 = new ParsingInputString(inputString1);
        CalculateIntegerList calculateIntegerList1 = new CalculateIntegerList(inputString1);

        InputString inputString2 = new InputString("");
        ParsingInputString parsingInputString2 = new ParsingInputString(inputString2);
        CalculateIntegerList calculateIntegerList2 = new CalculateIntegerList(inputString2);

        InputString inputString3 = new InputString("//;\\n");
        ParsingInputString parsingInputString3 = new ParsingInputString(inputString3);
        CalculateIntegerList calculateIntegerList3 = new CalculateIntegerList(inputString3);

        //when
        parsingInputString1.findCustomChar();
        parsingInputString1.parsingInput();
        int calculate1 = calculateIntegerList1.calculate();

        parsingInputString2.findCustomChar();
        parsingInputString2.parsingInput();
        int calculate2 = calculateIntegerList2.calculate();

        parsingInputString3.findCustomChar();
        parsingInputString3.parsingInput();
        int calculate3 = calculateIntegerList3.calculate();

        //then
        assertThat(calculate1).isEqualTo(0);
        assertThat(calculate2).isEqualTo(0);
        assertThat(calculate3).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
