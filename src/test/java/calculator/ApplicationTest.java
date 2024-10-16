package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.ScenarioRunner;
import calculator.controller.CalculateIntegerList;
import calculator.controller.FindCustomChar;
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
        ParsingInputString parsingInputString = new ParsingInputString();
        List<String> numberStringList = parsingInputString.parsingInput(inputString);
        List<Integer> numberList = parsingInputString.getNumberList(inputString, numberStringList);

        //then
        assertThat(numberList).isEqualTo(List.of(12, 3, 4, 6));
        assertThat(inputString.getNumberList()).isEqualTo(List.of(12, 3, 4, 6));
    }

    @Test
    @DisplayName("계산 메서드의 동작을 확인한다.")
    void calculateTest() {
        //given
        InputString inputString = new InputString("1,2,3:4");
        inputString.setNumberList(List.of(1, 2, 3, 4));

        //when
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList();
        int calculateResult = calculateIntegerList.calculateResult(inputString);

        //then
        assertThat(calculateResult).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자 파싱 메서드를 확인한다.")
    void findCustomTest() {
        //given
        InputString inputString = new InputString("//;\\n1,2,3:4;9");

        //when
        FindCustomChar findCustomChar = new FindCustomChar();
        findCustomChar.setCustomChar(inputString);

        //then
        assertThat(inputString.getCustomChar()).isEqualTo(';');
    }

    @Test
    @DisplayName("특정 케이스를 확인한다.")
    void edgeCaseTest() {
        //given
        InputString inputString1 = new InputString("//\\n");
        ScenarioRunner scenarioRunner1 = new ScenarioRunner(inputString1);

        InputString inputString2 = new InputString("");
        ScenarioRunner scenarioRunner2 = new ScenarioRunner(inputString2);

        InputString inputString3 = new InputString("//;\\n");
        ScenarioRunner scenarioRunner3 = new ScenarioRunner(inputString3);

        //when
        int calculate1 = scenarioRunner1.runScenario();
        int calculate2 = scenarioRunner2.runScenario();
        int calculate3 = scenarioRunner3.runScenario();

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
