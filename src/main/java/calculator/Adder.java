package calculator;

import java.util.List;

public class Adder {
    long answer;

    public void add(List<String> numbers) {
        answer = 0;
        for (String number: numbers) {
            if (number.isBlank()) {
                continue;
            }
            long element = Long.parseLong(number);
            validateOverflow(element);
            answer += element;
        }
        validateOverflow(answer);
    }

    public long getAnswer() {
        return answer;
    }

    private void validateOverflow(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("허용 범위를 초과하였습니다.");
        }
    }
}
