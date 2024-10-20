package calculator.domain;

public class Delimiter {
    private String value;

    public Delimiter(String value) {
        this.value = value.replace("([\\W])", "\\\\$1");
    }

    public void validate() {
        if(value.length() > 1)
            throw new IllegalArgumentException("커스텀 구분자는 1자리여야 합니다.");
        if(value.isEmpty())
            throw new IllegalArgumentException("커스텀 구분자는 비어있을 수 없습니다.");
    }

    public String getValue() {
        return value;
    }
}
