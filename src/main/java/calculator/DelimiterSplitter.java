package calculator;

public class DelimiterSplitter {
    private String str;

    public DelimiterSplitter(String str) {
        this.str = str;
    }

    public String[] split() {
        return basicDelimiterSplit();
    }

    private String[] basicDelimiterSplit() {
        return str.split(",|:");
    }
}
