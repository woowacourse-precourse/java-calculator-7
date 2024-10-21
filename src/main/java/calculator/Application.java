package calculator;

import java.util.List;

import calculator.validator.InputValidator;
import calculator.view.View;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		View view = new View();
		InputValidator inputValidator = new InputValidator();
		String input = view.getInput();
		String[] splited = inputValidator.validateInputSplittable(input);
		List<Integer> integers = inputValidator.validatePositiveNumbers(splited);

		view.printOutput(getSum(integers));
	}

	private static long getSum(List<Integer> integers) {
		return integers.stream()
			.reduce(Integer::sum)
			.orElseThrow(IllegalArgumentException::new);
	}
}
