package calculator;

public enum InfoMessage {
    INPUT("덧셈할 문자열을 입력해 주세요.\n"),
    RESULT("결과 : %d\n");

    private String msg;

    InfoMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
