package calculator.view.enumerate;

public enum Phrase {
    RESULT_PRINT_SENTENCE("결과 : %d"),
    START_PRINT_SENTENCE("덧셈할 문자열을 입력해 주세요.");

    private final String sentence;

    // 생성자
    Phrase(String sentence) {
        this.sentence = sentence;
    }

    // getter 메서드
    public String getSentence() {
        return sentence;
    }
}
