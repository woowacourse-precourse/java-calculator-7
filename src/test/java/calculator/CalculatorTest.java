package calculator;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest  {


    @Test
    void 입력이_올바를때_add(){
        Calculator calculator = new Calculator();
        String input = "1,2,3";

        assertSimpleTest(() -> {
            assertThat(calculator.add(input)).isEqualTo(6);
        });
    }

    @Test
    void 음수가_입력됐을때_예외가_발생(){
        Calculator calculator = new Calculator();
        String input = "1,-2,3";

        assertThatThrownBy(() -> {
            calculator.add(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 숫자를 입력해주세요");
    }

    @Test
    void 숫자대신_문자가_입력됐을때_예외가_발생(){
        Calculator calculator = new Calculator();
        String input = "1,a,3";

        assertThatThrownBy(() -> {
            calculator.add(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("조건에 맞게 입력해주세요");
    }
    @Test
    void 올바른_커스텀구분자_입력으로_계산이_실행될때(){
        Calculator calculator = new Calculator();
        String input = "//;\\n1;2;3";

        assertSimpleTest(() ->{
            assertThat(calculator.add(input)).isEqualTo(6);
        });
    }

    @Test
    void 잘못된_커스텀구분자_입력으로_계산이_실행될때(){
        Calculator calculator = new Calculator();
        String input = "//;\\n1,2,3";
        assertThatThrownBy(() ->{
            calculator.add(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("조건에 맞게 입력해주세요");
    }

}
