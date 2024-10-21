package calculator;

import java.util.List;

public class Application {
    static int sum(List<Integer> numbers) {
        return numbers
            .stream()
            .reduce(Integer::sum)
            .orElse(0);
    }

    public static void main(String[] args) {
    }
}
