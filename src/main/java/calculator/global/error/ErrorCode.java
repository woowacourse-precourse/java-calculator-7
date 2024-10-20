package calculator.global.error;

public enum ErrorCode {

    NUMERIC_ERROR_MESSAGE("[ERROR] 숫자만 입력해야 합니다.(특수문자는 제외)"),
    NOT_POSITIVE_ERROR_MESSAGE("[ERROR] 양의 숫자만 입력해야 합니다.(특수문자는 제외)");

    private String errorMsg;

    ErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}