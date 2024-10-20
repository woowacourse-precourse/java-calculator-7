package calculator.global;

public enum DelimiterMarker {

    PREFIX("//"), // 커스텀 생성자 앞부분
    SUFFIX("\\n"); // 커스텀 생성자 뒷부분

    private final String key;

    DelimiterMarker(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
