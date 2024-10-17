package calculator;

import calculator.model.Separator;
import calculator.service.CalculateService;
import calculator.service.SplitService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceTest extends NsTest {

    private CalculateService calculateService = CalculateService.getInstance();
    private SplitService splitService = SplitService.getInstance();

    @Test
    void 리스트의_숫자들의_총합_계산(){
        //given
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        //when
        String result = calculateService.calculate(numbers);

        //then
        Assertions.assertEquals("10", result);
    }

    @Test
    void 숫자와_구분자로_이루어진_문자열_분리_1(){
        //given
        String numbers = "1:2:3:4";
        Separator separators = new Separator();

        //when
        List<String> expect = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> result = splitService.splitNumber(separators, numbers);

        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void 숫자와_구분자로_이루어진_문자열_분리_2(){
        //given
        String numbers = "1,2,3,4";
        Separator separators = new Separator();

        //when
        List<String> expect = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> result = splitService.splitNumber(separators, numbers);

        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void 숫자와_구분자로_이루어진_문자열_분리_custom_separator(){
        //given
        String numbers = "1/2,3:4";
        Separator separators = new Separator();
        separators.registerSeparator("/");

        //when
        List<String> expect = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> result = splitService.splitNumber(separators, numbers);

        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void 구분자_추출() {
        //given
        String input = "//;\\n1;2;3";

        //when
        String[] result = splitService.extractCustomSeparatorAndNumbers(input);

        //then
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(";", result[0]);
        Assertions.assertEquals("1;2;3", result[1]);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
