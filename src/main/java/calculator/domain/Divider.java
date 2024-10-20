package calculator.domain;

public class Divider {
    private final static String COMMA = ",";
    private final static String COLON = ":";
    private String customDivider;

    public Divider() {
    }

    public void setCustomDivider(String customDivider) {
        this.customDivider = customDivider;
    }

    public String getComma() {
        return COMMA;
    }

    public String getColon() {
        return COLON;
    }

    public String getCustomDivider() {
        return customDivider;
    }

}
