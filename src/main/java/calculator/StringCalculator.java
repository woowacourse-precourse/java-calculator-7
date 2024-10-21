package calculator;

import calculator.numberExtractor.NumberExtractor;
import calculator.separatorProvider.SeparatorProvider;
import java.util.List;

/**
 * 문자열을 읽어 덧셈을 수행하는 역할
 */
public class StringCalculator {

	private final StringParser stringParser;
	private final Calculator calculator;

	public StringCalculator(
			SeparatorProvider separatorProvider,
			NumberExtractor numberExtractor,
			Calculator calculator
	) {
		this.stringParser = new StringParser(separatorProvider, numberExtractor);
		this.calculator = calculator;
	}

	/**
	 * 커스텀구분자 문자열과 숫자 문자열을 읽어 적절히 계산하여 반환한다.
	 *
	 * @param customSeparatorPart 커스텀구분자 문자열
	 * @param numberPart          숫자 문자열
	 * @return 덧셈 결과
	 */
	public int calculate(String customSeparatorPart, String numberPart) {
		List<Integer> numbers = stringParser.parse(customSeparatorPart, numberPart);

		return calculator.add(numbers);
	}
}
