package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    private final Calculator calculator;

    public CalculatorTest(){
        calculator = new Calculator();
    }

    @Test
    void 빈_문자열() {
        long result = calculator.calculate("");
        Assertions.assertEquals(result, 0);
    }

    @Test
    void 음수_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("-1:2:3");
        });
    }

    @Test
    void 문자열에_0_포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("0,1,2,3,4");
        });
    }

    @Test
    void 커스텀구분자만_입력() {
        long result = calculator.calculate("//;\\n");
        Assertions.assertEquals(result, 0);
    }

    @Test
    void null_값_입력() {
        long result = calculator.calculate(null);
        Assertions.assertEquals(result, 0);
    }

    @Test
    void 구분자로_쉼표_입력() {
        long result = calculator.calculate("1,2,3,4,5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 구분자로_콜론_입력() {
        long result = calculator.calculate("1:2:3:4:5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 구분자로_쉼표와_콜론() {
        long result = calculator.calculate("1,2,3:4:5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 구분자_사이에_빈_문자열() {
        long result = calculator.calculate("1,2,,4,5");
        Assertions.assertEquals(result, 12);
    }

    @Test
    void 구분자로_시작() {
        assertSimpleTest(() -> {
            long result = calculator.calculate(",2,3,4,5");
            Assertions.assertEquals(result, 14);
        });
    }

    @Test
    void 구분자_뒤에_빈문자열() {
        long result = calculator.calculate("1,2,3,4,");
        Assertions.assertEquals(result, 10);
    }

    @Test
    void 양수_대신_문자열() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1:2:3,a,5");
        });
    }

    @Test
    void 입력_범위_초과() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(String.valueOf(Long.MAX_VALUE + 1));
        });
    }

    @Test
    void 문자열에_float_포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("0.1,2,3,4,5");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        long result = calculator.calculate("//;\\n1;2;3;4;5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 커스텀_구분자로_빈문자열() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            calculator.calculate("//\\n;1,2,3,4,5");
        });
    }

    @Test
    void 커스텀_구분자_종료_문자열_없음() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            calculator.calculate("//;1,2,3,4,5");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자_함께_사용() {
        long result = calculator.calculate("//;\\n1,2:3,4;5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 커스텀_구분자의_길이가_2이상() {
        long result = calculator.calculate("//;;\\n1;;2;;3;;4;;5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 기본_구분자를_포함하는_커스텀_구분자() {
        long result = calculator.calculate("//,:,\\n1,:,2,:,3,:,4,:,5");
        Assertions.assertEquals(result, 15);
    }

    @Test
    void 숫자가_0으로_시작() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("01,02,03,04,05");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
