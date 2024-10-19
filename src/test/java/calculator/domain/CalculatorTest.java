package calculator.domain;
import calculator.validation.MessageType;
import calculator.validation.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 올바른_계산값을_반환(){
        String input="//!\\n23,:3";
        Calculator calculator=new Calculator(input);
        assertThat(calculator.inputCalculate()).isEqualTo(26);
    }

    @Test
    void 존재하지_않는_커스텀_구분자_예외_발생(){
        String input="//!\\n1:~2";
        Calculator calculator=new Calculator(input);
        assertThatThrownBy(()->calculator.inputCalculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.INVALID_SEPERATOR.getMessage());
    }

    @Test
    void 숫자가_구분자일때_예외_발생() throws Exception{
        String input="//3\\n12";
        Calculator calculator=new Calculator(input);
        assertThatThrownBy(()->calculator.inputCalculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.NUMBER_SEPERATOR.getMessage());
    }


}