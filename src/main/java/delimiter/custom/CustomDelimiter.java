package delimiter.custom;

public enum CustomDelimiter {

    START("//"),
    END("\\n");

    private final String description;

    CustomDelimiter(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
