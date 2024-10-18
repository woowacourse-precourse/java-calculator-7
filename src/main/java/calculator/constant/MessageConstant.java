package calculator.constant;

//public class MessageConstant {
//}
public enum MessageConstant {

    INPUT_ADDITION("덧셈할 문자열을 입력해 주세요. "),
    ADDITION_RESULT("결과 : %d");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
