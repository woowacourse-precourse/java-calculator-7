package calculator;

import static org.assertj.core.api.Assertions.*;

import calculator.parser.Parser;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class CalculatorTest {
	private Calculator calculator;

	@Test
	void 수식_합산_성공() {
		calculator = new Calculator(new SuccessTestParser());

		assertThatNoException().isThrownBy(() -> calculator.calculate("1,2,3"));
	}

	@Test
	void 수식_합산_실패_음수_포함() {
		calculator = new Calculator(new FailTestParser());

		assertThatIllegalArgumentException()
				.isThrownBy(() -> calculator.calculate("-1,2,3"));
	}

	private static class SuccessTestParser extends Parser {

		@Override
		public List<Integer> parse(String expression) {
			return Arrays.asList(1,2,3);
		}
	}

	private static class FailTestParser extends Parser {

		@Override
		public List<Integer> parse(String expression) {
			return Arrays.asList(-1,2,3);
		}
	}
}
