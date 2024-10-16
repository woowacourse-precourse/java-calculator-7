package calculator.Constants;

public enum ViewConstants {
    START("덧셈할 문자열을 입력해 주세요.");

    private final String message;
    ViewConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
