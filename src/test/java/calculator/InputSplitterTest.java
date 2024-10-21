package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputSplitterTest {
    @Test
    public void 특수_구분자_없는_올바른_인풋_빈_문자열() throws Exception{
        int[] result = InputSplitter.split("");
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo(0);
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표만() throws Exception{
        int[] result = InputSplitter.split("1,2,2,3");
        assertThat(result).isEqualTo(new int[]{1, 2, 2, 3});

    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_콜론만() throws Exception{
        int[] result = InputSplitter.split("3;4;2;");
        assertThat(result).isEqualTo(new int[]{3, 4, 2});
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_쉼표_콜론_혼합() throws Exception{
        int[] result = InputSplitter.split("1,3;4,2");
        assertThat(result).isEqualTo(new int[]{1, 3, 4, 2});
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_빈_문자열() throws Exception{
        int[] result = InputSplitter.split("//d\\n");
        assertThat(result).isEqualTo(new int[]{0});
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_구분자가_공백문자() throws Exception{
        int[] result = InputSplitter.split("//\\n1223");
        assertThat(result).isEqualTo(new int[]{1, 2, 2, 3});
    }
    @Test
    public void 특수_구분자_있는_올바른_인풋_구분자가_공백문자_아님() throws Exception{
        int[] result = InputSplitter.split("//d\\nd3d4d2d");
        assertThat(result).isEqualTo(new int[]{3, 4, 2});
    }

    @Test
    public void 특수_구분자_없는_틀린_인풋_다른_구분자_존재() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> InputSplitter.split("1,2f4;3"));
    }
    @Test
    public void 특수_구분자_없는_올바른_인풋_구분자_없음() throws Exception{
        int[] result = InputSplitter.split("12343");
        assertThat(result).isEqualTo(new int[]{12343});
    }
    @Test
    public void 특수_구분자_있는_틀린_인풋_다른_구분자_존재() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> InputSplitter.split("//a\\n1a2a4;3"));
    }
}