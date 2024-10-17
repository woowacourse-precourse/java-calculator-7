package calculator.domain;

public class CharExtractor {
    private String input;
    private int currentIndex;

    public CharExtractor(String input) {
        this.input = input;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < input.length();
    }

    public Character nextChar() {
        if (!hasNext()) {
            throw new IllegalStateException("더 이상 문자가 없습니다.");
        }

        return input.charAt(currentIndex++);
    }
}
