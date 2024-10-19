package calculator;

public class Calculator {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void addNumbers(String[] stringNumbers) {
        for (String stringNumber : stringNumbers) {
            try {
                sum += Integer.parseInt(stringNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 파싱 실패");
            }
        }
    }
}
