package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorModelTest extends NsTest {

    @Test
    public void 정상_계산한_경우_1(){
        String input = "1,2,3";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 6);
    }

    @Test
    public void 정상_계산한_경우_2(){
        String input = "1;2;3;4";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 10);
    }

    @Test
    public void 정상_계산한_경우_3(){
        String input = "1,2,3;4;5";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 15);
    }

    @Test
    public void 커스텀_지정자_포함_정상_계산한_경우_1(){
        String input = "//;\n1;2;3";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 6);
    }

    @Test
    public void 커스텀_지정자_포함_정상_계산한_경우_2(){
        String input = "//*\n1*2;13";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 16);
    }

    @Test
    public void 커스텀_지정자_포함_정상_계산한_경우_3(){
        String input = "//~\n1~2~3~4";
        Calculator calculator = new Calculator();
        Integer result = calculator.add(input);
        assertEquals(result, 10);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
