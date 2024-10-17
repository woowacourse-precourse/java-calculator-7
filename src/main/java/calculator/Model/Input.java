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

    public int getCustomDelimiterStartIndex(String rawText) {
        return rawText.indexOf("//") + 2;
    }

    public int getCustomDelimiterEndIndex(String rawText) {
        return rawText.indexOf("\n");
    }

    public int checkHasCustomDelimiter(String rawText) {
        int customDelimiterStartIndex = getCustomDelimiterStartIndex(rawText);
        int customDelimiterEndIndex = getCustomDelimiterEndIndex(rawText);
        if (customDelimiterStartIndex == 2 && customDelimiterEndIndex > 2) {
            return customDelimiterEndIndex;
        }
        return 0;
    }

    public String splitCustomDelimiter(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            return rawText.substring(2, customDelimiterEndIndex);
        }
        return null;
    }

    public String splitText(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            return rawText.substring(customDelimiterEndIndex+1);
        }
        return rawText;
    }

    public void getInputText(String rawText) {
        // 추후 기능 추가
        int customDelimiterEndIndex = checkHasCustomDelimiter(rawText);
        this.delimiter = splitCustomDelimiter(customDelimiterEndIndex, rawText);
        this.text = splitText(customDelimiterEndIndex, rawText);
    }
}
