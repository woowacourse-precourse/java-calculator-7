package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Tokenization tokenizer = new Tokenization(input);
        List<Integer> tokens = tokenizer.tokenize();
        Calculation calculation = new Calculation(tokens);
        int result = calculation.Calculate();

        System.out.println("결과 : " + result);
    }
}
