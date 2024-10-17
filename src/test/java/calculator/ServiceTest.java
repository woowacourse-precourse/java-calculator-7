package calculator;

import calculator.service.CalculateService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceTest extends NsTest {

    private CalculateService calculateService = CalculateService.getInstance();

    @Test
    void 리스트의_숫자들의_총합_계산(){
        //given
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        //when
        String result = calculateService.calculate(numbers);

        //then
        Assertions.assertEquals("10", result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
