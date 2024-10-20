package calculator.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    @Test
    void 음수_또는_zero_예외_테스트() {
        //given: "3:-3:2"
        CalculatorService calculatorService = new CalculatorService();
        String input = "3:-3:2";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("음수 또는 0은 입력할 수 없습니다."));
        }
    }

    @Test
    void 경계값_구분자_예외_테스트() {
        //given: ":3:2:3"
        CalculatorService calculatorService = new CalculatorService();
        String input = ":3:2:3";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("경계값에 구분자가 들어갈 수 없습니다."));
        }
    }

    @Test
    void 구분자_아닌_문자_예외_테스트() {
        //given: "3-3:2"
        CalculatorService calculatorService = new CalculatorService();
        String input = "3-3:2";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("숫자와 구분자를 제외한 문자는 입력할 수 없습니다."));
        }
    }

    @Test
    void 공백_포함시_예외_테스트() {
        //given: "3: 3:2"
        CalculatorService calculatorService = new CalculatorService();
        String input = "3: 3:2";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("공백은 입력할 수 없습니다."));
        }
    }

    @Test
    void 구분자_여러개_중첩_예외_테스트() {
        //given: "3:::-3:2"
        CalculatorService calculatorService = new CalculatorService();
        String input = "3:::-3:2";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("구분자를 연속해서 입력할 수 없습니다."));
        }
    }

    @Test
    void 커스텀_구분자_숫자_예외_테스트() {
        //given: "//3\\n231"
        CalculatorService calculatorService = new CalculatorService();
        String input = "//3\\n231";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("커스텀 구분자에 숫자와 '-'를 포함할 수 없습니다."));
        }
    }

    @Test
    void 커스텀_구분자_하이픈_예외_테스트() {
        //given: "//3\\n231"
        CalculatorService calculatorService = new CalculatorService();
        String input = "//-\\n231";

        // when & then
        try {
            calculatorService.calculate(input);
            fail("IllegalArgumentException 발생 안 함");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 성공
            assertTrue(e.getMessage().equals("커스텀 구분자에 숫자와 '-'를 포함할 수 없습니다."));
        }
    }
}
