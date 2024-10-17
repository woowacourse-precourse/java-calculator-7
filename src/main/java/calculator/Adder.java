package calculator;

import java.util.List;

public class Adder {
    int answer;

    public void add(List<String> numbers) {
        answer = 0;
        for (String number: numbers) {
            if (number.isBlank()) {
                continue;
            }
            answer += Integer.parseInt(number);
        }
    }
}
