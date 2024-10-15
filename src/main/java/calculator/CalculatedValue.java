package calculator;

public class CalculatedValue {
    private String value;

    public CalculatedValue(String value) {
        System.out.println("처음 들어온 값"+value);
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
