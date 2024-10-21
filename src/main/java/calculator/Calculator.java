package calculator;

public class Calculator {

    public int getSum(String [] split) {
        int result = 0;
        for (String s : split) {
            try {
                result += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
