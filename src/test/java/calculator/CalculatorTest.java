package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private final Calculator calculator = new Calculator();

	@Test
	void 기본_구분자_분리() {
		int result = calculator.separateInput("1,2,3");
		assertEquals(6, result);
	}


	@Test
	void 기본_구분자_여러개_분리() {
		int result = calculator.separateInput("1,2:3,4");
		assertEquals(10, result);
	}

	@Test
	void 커스텀_구분자_분리() {
		int result = calculator.separateInput("//;\\n1;2;3");
		assertEquals(6, result);
	}

	@Test
	void 음수_예외처리() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.separateInput("1,-2,3");
		});
		assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
	}
}