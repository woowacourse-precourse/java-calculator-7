package calculator.domain;

public class Divider {
    private final static String COMMA = ",";
    private final static String CLON = ":";
    private String customDivider;

    public Divider() {
    }

    public void setCustomDivider(String customDivider) {
        this.customDivider = customDivider;
    }

    public String getComma(){
        return COMMA;
    }

    public String getClon(){
        return CLON;
    }

    public String getCustomDivider(){
        return customDivider;
    }

}
