package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void 결과값_계산_성공() {
        //given
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        //when
        int result = calculator.calculate(list);

        //then
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 결과값_계산_실패_음수포함() {
        //given
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("-5");

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(list),
                "0 또는 음수는 입력값에 포함될 수 없습니다.");
    }

}