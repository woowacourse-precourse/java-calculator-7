package calculator.system.exception;

enum SystemError {
	INVALID_DELIMITER("커스텀 구분자는 반점(,)과 콜론(:)이외의 문자로 지정해야 합니다."),
	NEGATIVE_NUMBER("음수는 입력할 수 없습니다.");

	private final String message;

	SystemError(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
