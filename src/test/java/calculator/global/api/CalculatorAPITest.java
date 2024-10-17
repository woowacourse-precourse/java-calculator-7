package calculator.global.api;

import calculator.domain.Number;
import calculator.global.config.APIFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAPITest {

	@Test
	@DisplayName("기능 테스트")
	void answerTest() {
		APIFactory apiFactory = APIFactory.getInstance();
		CalculatorAPI calculatorAPI = apiFactory.calculator();
		Number number = Number.getInstance();

		//given
		number.addNumber(1);
		number.addNumber(2);
		number.addNumber(3);

		//when
		int answer = calculatorAPI.answer();

		//then
		assertEquals(1, number.getNumber(0));
		assertEquals(2, number.getNumber(1));
		assertEquals(3, number.getNumber(2));
		assertEquals(3, number.getSize());
		assertEquals(6, answer);
	}
}