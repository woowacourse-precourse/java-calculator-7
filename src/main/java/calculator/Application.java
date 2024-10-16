package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String user_input = Console.readLine();
        char[] separators = {',',':'};
        String[] tokens = Tokenizer.tokenize(separators,user_input);
        int[] nums = Tokenizer.tokensToNums(tokens);
        System.out.println("결과 : " + IntStream.of(nums).sum());
    }

}
