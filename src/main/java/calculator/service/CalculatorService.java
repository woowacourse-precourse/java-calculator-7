package calculator.service;

import static calculator.exception.ErrorMessage.*;

public class CalculatorService {

	private static final int ZERO = 0;
	private final InputService inputService;

	public CalculatorService(InputService inputService) {
		this.inputService = inputService;
	}

	public long calculate(String input) {
		input = inputService.removeBlank(input);
		if (input == null || input.isEmpty()) {
			return 0L;
		}
		String[] numbers = inputService.splitInput(input);
		return sum(numbers);
	}

	private long sum(String[] numbers) {
		long total = ZERO;
		for (String number : numbers) {
			long parsedNumber = toLong(number);
			total += parsedNumber;
		}
		return total;
	}

	private long toLong(String number) {
		try {
			long parsedNumber = Long.parseLong(number);
			if (parsedNumber < ZERO) {
				throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage()); // 음수 체크
			}
			return parsedNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_INPUT.getMessage());
		}
	}

}