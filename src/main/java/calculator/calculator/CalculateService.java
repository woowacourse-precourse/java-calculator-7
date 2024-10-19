package calculator.calculator;

public class CalculateService {

    public int calculate(String[] array) {
        int result = 0;
        for (String s : array) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
