package calculator.Model;

public class Input {
    String delimiter;
    String text;

    public boolean hasDelimiter() {
        return delimiter != null;
    }

    public boolean hasText() {
        return text != null;
    }

    public void getInputText(String inputText) {
        // 추후 기능 추가
        this.text = inputText;
    }
}
