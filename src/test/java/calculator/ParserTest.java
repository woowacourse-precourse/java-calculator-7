package calculator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    public void 기본연산테스트1() throws Exception {
        //given
        String inputString = "";
        //when
        Parser parser = new Parser();
        parser.parse(inputString);
        List<Integer> nums = parser.getNums();
        int sum = Calculator.sum(nums);
        //then
        Assertions.assertThat(sum).isEqualTo(0);
    }

    @Test
    public void 기본연산테스트2() throws Exception {
        //given
        String inputString = "1,2";
        //when
        Parser parser = new Parser();
        parser.parse(inputString);
        List<Integer> nums = parser.getNums();
        int sum = Calculator.sum(nums);
        //then
        Assertions.assertThat(sum).isEqualTo(3);
    }

    @Test
    public void 기본연산테스트3() throws Exception {
        //given
        String inputString = "1,2,3";
        //when
        Parser parser = new Parser();
        parser.parse(inputString);
        List<Integer> nums = parser.getNums();
        int sum = Calculator.sum(nums);
        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }

    @Test
    public void 기본연산테스트4() throws Exception {
        //given
        String inputString = "1,2:3";
        //when
        Parser parser = new Parser();
        parser.parse(inputString);
        List<Integer> nums = parser.getNums();
        int sum = Calculator.sum(nums);
        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }
}