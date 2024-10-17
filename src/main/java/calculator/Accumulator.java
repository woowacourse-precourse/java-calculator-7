package calculator;

public class Accumulator {

    public int sum(String[] input) {
        int sum = 0;

        for (String s : input) {
            sum += Integer.parseInt(s.trim());
        }

        return sum;
    }
}
