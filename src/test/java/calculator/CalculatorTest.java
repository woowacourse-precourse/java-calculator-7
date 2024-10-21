package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 빈_문자열_입력_테스트() {
        // Given : 빈 문자열 입력값
        String input = "";

        // When : Calculator의 extractNumbers 메서드를 실행
        Calculator calculator = new Calculator();
        String[] result = calculator.extractNumbers(input);

        // Then : 예상되는 결과값과 비교 (0이 담긴 배열이 리턴되는지)
        assertArrayEquals(new String[]{"0"}, result);

    }

    @Test
    void 커스텀_구분자_숫자_추출_테스트() {
        // Given : 커스텀 구분자가 적용된 입력 값
        String input = "//$\n68$32$3";

        // When : Calculator의 extractNumbers 메서드를 실행
        Calculator calculator = new Calculator();
        String[] result = calculator.extractNumbers(input);

        // Then : 예상되는 결과값과 비교 (숫자가 제대로 추출되는지)
        assertArrayEquals(new String[]{"68", "32", "3"}, result);
    }

    @Test
    void 숫자_추출_테스트() {
        // Given : 쉼표와 콜론으로 구분된 숫자가 있는 입력값
        String input = "9:6,3";

        // When : Calculator의 extractNumbers 메서드를 실행
        Calculator calculator = new Calculator();
        String[] result = calculator.extractNumbers(input);

        // Then : 예상되는 결과값과 비교 (숫자가 제대로 추출되는지)
        assertArrayEquals(new String[]{"9", "6", "3"}, result);
    }

    @Test
    void 숫자_합산_테스트() {
        // Given : 쉼표와 콜론으로 구분된 숫자가 있는 입력값
        String input = "12:6,9";

        // When : Calculator의 sumNumbers 메서드를 실행
        Calculator calculator = new Calculator();
        int result = calculator.sumNumbers(input);

        // Then : 합산된 결과값이 예상대로 나오는지 확인
        assertEquals(27, result);
    }

    @Test
    void 커스텀_구분자_숫자_합산_테스트() {
        // Given : 커스텀 구분자가 적용된 입력 값
        String input = "//!\n7!1!4";

        // When : Calculator의 sumNumbers 메서드를 실행
        Calculator calculator = new Calculator();
        int result = calculator.sumNumbers(input);

        // Then : 합산된 결과값이 예상대로 나오는지 확인
        assertEquals(12, result);
    }
}
