package calculator;

public class Number {
    private final String number;

    public Number(String number) {
        if (number.equals("\"\"")) {
            number = "0";
        }
        validate(number);
        this.number = number;
    }

    private void validate(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("숫자에 빈 값을 입력할 수 없습니다");
        }

        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("숫자 외의 문자는 입력할 수 없습니다");
        }

        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다");
        }
    }

    public String getNumber() {
        return number;
    }
}
