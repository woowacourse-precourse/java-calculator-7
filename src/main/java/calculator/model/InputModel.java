package calculator.model;

import calculator.constants.ExceptionMessage;

public class InputModel {
	private final String input;

	public InputModel(String input) {
		validateInput(input);
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	private void validateInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
		}
	}
}
