package calculator.util;

public enum Message {
    INTRO("덧셈할 문자열을 입력해 주세요.\n문자열은 구분자와 양수로만 입력가능합니다."),
    RESULT("결과 : ");

    String sentence;

    Message(String sentence){
        this.sentence = sentence;
    }

    public String getSentence(){
        return sentence;
    }
}
