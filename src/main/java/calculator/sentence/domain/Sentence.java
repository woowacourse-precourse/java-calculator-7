package calculator.sentence.domain;


public class Sentence {
    private final String sentence;
    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
