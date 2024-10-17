package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.CalculateApplication;
import calculator.controller.CalculateIntegerList;
import calculator.controller.CustomCharStrategy;
import calculator.model.InputString;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
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
        InputString inputString = new InputString("//&\\n12,3:46", "[,:]", new ArrayList<>());

        //when
        InputString afterInputString = CustomCharStrategy.findCustomChar(inputString);

        //then
        assertThat(afterInputString.splitString()).isEqualTo("[,:&]");
    }

    @Test
    @DisplayName("계산 메서드의 동작을 확인한다.")
    void calculateTest() {
        //given
        List<String> numberList = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        InputString inputString = new InputString("1,2,3:4", "[,:]", numberList);

        //when
        int calculateResult = CalculateIntegerList.calculateResult(inputString);

        //then
        assertThat(calculateResult).isEqualTo(10);
    }

    @Test
    @DisplayName("특정 케이스를 확인한다.")
    void edgeCaseTest() {
        //given
        InputString inputString1 = new InputString("//\\n","[,:]", new ArrayList<>());
        InputString inputString2 = new InputString("","[,:]", new ArrayList<>());
        InputString inputString3 = new InputString("//;\\n","[,:]", new ArrayList<>());

        //when
        int calculate1 = CalculateApplication.run(inputString1);
        int calculate2 = CalculateApplication.run(inputString2);
        int calculate3 = CalculateApplication.run(inputString3);

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
