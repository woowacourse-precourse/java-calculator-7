package calculator.model;

public enum Status {
	DIGIT, DELIMITER;

	public static Status checkStatus(char input) {
		if (Character.isDigit(input)) {
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
