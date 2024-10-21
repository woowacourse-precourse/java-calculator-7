package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    public void 특수_구분자_없는_올바른_인풋_빈_문자열() throws Exception{
        String userNumberInput = inputHandler.getUserNumberInput();
        Assertions.assertThat(userNumberInput).isEqualTo("");
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표만() throws Exception{
        String userNumberInput = inputHandler.getUserNumberInput();
        Assertions.assertThat(userNumberInput).isEqualTo("1,2");
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_콜론만() throws Exception{
        String userNumberInput = inputHandler.getUserNumberInput();
        Assertions.assertThat(userNumberInput).isEqualTo("1,2,3");
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표_콜론_혼합() throws Exception{
        String userNumberInput = inputHandler.getUserNumberInput();
        Assertions.assertThat(userNumberInput).isEqualTo("1;2,3");
    }
    @Test
    public void 특수_구분자_없는_틀린_인풋_공백_존재() throws Exception{
        assertThrows(IllegalArgumentException.class, inputHandler::getUserNumberInput);
    }
}