package calculator;

import java.util.Arrays;

public class Calculator {
    //todo: 추출한 문자를 숫자로 바꿔서 계산
    public void run() {
        String input = View.userInput();

        Validation.validate(input);

        String[] result = Separation.separate(input);
        int sum = Arrays.stream(result)
                .mapToInt(Integer::parseInt)
                .sum();
        View.output(sum);
    }
}
