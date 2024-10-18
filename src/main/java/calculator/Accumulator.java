package calculator;

public class Accumulator {

    public int sum(String[] input) {
        int sum = 0;

        for (String s : input) {
            if (s.isEmpty()) {
                sum += 0;
                continue;
            }
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
