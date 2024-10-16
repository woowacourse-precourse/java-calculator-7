package calculator.domain;

public class Calculator {
    public int sum(String[] elements) {
        int num = 0;
        for (String element : elements) {
            num += Integer.parseInt(element);
        }
        return num;
    }
}
