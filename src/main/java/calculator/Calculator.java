package calculator;

public class Calculator {
    public int calculate(String str) {
        int sum = 0;
        String temp = "";
        Check checker = new Check();
        str = checker.check_last_char(str);
        char custom = checker.check_custom(str);
        int start = (custom != '\0') ? 5 : 0;

        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == ',' || str.charAt(i) == ':' || str.charAt(i) == custom) {
                if (temp.equals("")) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(temp);
                temp = "";
            } else {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    throw new IllegalArgumentException();
                }
                temp += str.charAt(i);
            }
        }
        return sum;
    }
}
