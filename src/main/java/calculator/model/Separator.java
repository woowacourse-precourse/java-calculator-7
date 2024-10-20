package calculator.model;

public class Separator {
    private final String comma = ",";
    private final String colon = ":";
    private String custom;

    // 커스텀 구분자 설정
    public void setCustomSeparator(String customSeparator) {
        this.custom = customSeparator;
    }

    public String getComma() {
        return comma;
    }

    public String getColon() {
        return colon;
    }

    public String getCustom() {
        return custom;
    }
}
