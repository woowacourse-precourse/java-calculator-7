package calculator.view;

import calculator.Application;
import calculator.Numbers;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @Test
    @DisplayName("소수점 여부에 따른 출력")
    void printResult() {
        //given
        OutputView outputView = new OutputView();
        List<Double> numberList1 = new ArrayList<>();
        numberList1.add(1d);
        numberList1.add(2d);
        numberList1.add(3d);
        Numbers numbers1 = new Numbers(numberList1);

        List<Double> numberList2 = new ArrayList<>();
        numberList2.add(1d);
        numberList2.add(2d);
        numberList2.add(3.2);
        Numbers numbers2 = new Numbers(numberList2);
        //when
        outputView.printResult(numbers1);
        outputView.printResult(numbers2);
        //then
        assertThat(output()).isEqualTo("결과 : 6\n"+"결과 : 6.2");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}