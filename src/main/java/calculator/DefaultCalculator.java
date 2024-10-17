package calculator;

public class DefaultCalculator implements Calculator {
    private String str;

    public DefaultCalculator(String str) {
        this.str = str;
    }

    @Override
    public int calculate() {
        int sum = 0, idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                if (!(ch == ',' || ch == ':')) {
                    throw new IllegalArgumentException();
                }
                int num = Integer.parseInt(str.substring(idx, i));
                idx = i + 1;
                sum += num;
            }
        }
        sum += Integer.parseInt(str.substring(idx));
        return sum;

    }
}
