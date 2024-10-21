package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    public void 특수_구분자_없는_올바른_인풋_빈_문자열() throws Exception{
        assertThat(InputValidator.validate("")).isTrue();
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표만() throws Exception{
        assertThat(InputValidator.validate("1,2,2,3")).isTrue();
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_콜론만() throws Exception{
        assertThat(InputValidator.validate("3;4;2;")).isTrue();
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표_콜론_혼합() throws Exception{
        assertThat(InputValidator.validate("1,3;4,2")).isTrue();
    }
    @Test
    public void 특수_구분자_없는_틀린_인풋_쉼표_콜론_숫자_이외의_문자_존재() throws Exception{
        assertThat(InputValidator.validate("1;2f,2;3")).isFalse();
        assertThat(InputValidator.validate("1;2,2 ;3")).isFalse();
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_빈_문자열() throws Exception{
        assertThat(InputValidator.validate("//d\\n")).isTrue();
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_구분자가_공백문자() throws Exception{
        assertThat(InputValidator.validate("//\\n1223")).isTrue();
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_구분자가_공백문자_아님() throws Exception{
        assertThat(InputValidator.validate("//d\\n3d4d2d")).isTrue();
    }

    @Test
    public void 특수_구분자_있는_틀린_인풋_다른_구분자_존재_그러나_형식_맞음() throws Exception{
        assertThat(InputValidator.validate("//d\\n1d3d4,2")).isTrue();
    }
    @Test
    public void 특수_구분자_있는_틀린_인풋_구분자_정의_형식_틀림() throws Exception{
        assertThat(InputValidator.validate("//d\\jn1d3d4,2")).isFalse();
    }
    @Test
    public void 특수_구분자_있는_틀린_인풋_구분자_정의_위치_틀림() throws Exception{
        assertThat(InputValidator.validate("1d3d4d2//d\\n")).isFalse();
    }
}