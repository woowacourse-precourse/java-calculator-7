package calculator.parser;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

public class LongMathematicalExpressionParserTest extends NsTest {

	private final LongMathematicalExpressionParser longMathematicalExpressionParser;
	private final static String DEFAULT_PATTERN = ",|:";

	public LongMathematicalExpressionParserTest() {
		longMathematicalExpressionParser = new LongMathematicalExpressionParser();
	}

	// 성공
	@Test
	@DisplayName("기본 구분자 사용 수식 입력 테스트")
	public void defaultSeparator() {
		assertSimpleTest(() -> {
			// given
			String input = "10,2:5,3:10";

			// when
			long[] numbers = longMathematicalExpressionParser.parse(input, DEFAULT_PATTERN);

			// then
			assertThat(numbers)
				.contains(10, 2, 5, 3, 10);
		});
	}

	@Test
	@DisplayName("기본 구분자와 커스텀 구분자가 동시에 존재할 때 수식 입력 테스트")
	public void defaultAndCustomSeparator() {
		assertSimpleTest(() -> {
			// given
			String input = "10;2,5:1-3]10";
			String pattern = DEFAULT_PATTERN + "|;|-|]";

			// when
			long[] numbers = longMathematicalExpressionParser.parse(input, pattern);

			// then
			assertThat(numbers)
				.contains(10, 2, 5, 1, 3, 10);
		});
	}

	// 실패
	@Test
	@DisplayName("없는 구분자가 포함된 수식 입력 테스트")
	public void hasNotSeparatorPattern() {
		assertSimpleTest(() -> {
			// given
			String input = "10,2:3;4,5";

			// when
			assertThatThrownBy(() -> longMathematicalExpressionParser.parse(input, DEFAULT_PATTERN))

				// then
				.isInstanceOf(IllegalArgumentException.class);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
