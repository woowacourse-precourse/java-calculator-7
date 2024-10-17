package calculator.core;

public enum CalculatorError {

	INVALID_INPUT("우효하지 않은 입력값입니다.");

	private final String message;

	CalculatorError(String s) {
		this.message=s;
	}

	public String getMessage(){
		return message;
	}

}
