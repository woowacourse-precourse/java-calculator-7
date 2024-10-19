package calculator.data;

public enum keywords {
    DOUBLE_SLASH("//"), NEW_LINE("\\n");

    private String keyword;

    keywords(String s) {
        this.keyword = s;
    }

    public String getKeyword() {
        return keyword;
    }
}
