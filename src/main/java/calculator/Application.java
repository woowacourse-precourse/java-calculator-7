package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String user_input = Console.readLine();
        Character[] default_separators = {',',':'};
        List<Character> separators = new ArrayList<> (Arrays.asList(default_separators));
        char[] customSeparators =  Tokenizer.getCustomSeparators(user_input);
        for (char c : customSeparators) {
            separators.add(c);
        }
        user_input = Tokenizer.removeHeader(user_input);
        String[] tokens = Tokenizer.tokenize(separators,user_input);
        int[] nums = Tokenizer.tokensToNums(tokens);
        System.out.println("결과 : " + IntStream.of(nums).sum());
    }

}
