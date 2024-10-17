package calculator;

public class CustomCalculator implements Calculator {
    private String str;
    private char operator;

    public CustomCalculator(String str) {
        this.str = str;
        this.operator = str.charAt(2);
    }

    @Override
    public int calculate() {
        int sum = 0, idx = 5;
        for (int i = 5; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == operator) {
                int num = Integer.parseInt(str.substring(idx, i));
                idx = i + 1;
                sum += num;
            }
        }
        sum += Integer.parseInt(str.substring(idx));
        return sum;
    }
}
