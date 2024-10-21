package calculator.model;

public enum Status {
	DIGIT, DELIMITER;

	public static Status checkStatus(String input) {
		if (input.isEmpty() || Character.isDigit(input.charAt(0))) {
			return DIGIT;
		}
		return DELIMITER;
	}

	public static Status changeStatus(Status status) {
		if (status == DIGIT) {
			return DELIMITER;
		}
		return DIGIT;
	}
}
