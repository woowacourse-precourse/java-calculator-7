package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Set<Character> defaultDelimiters = new HashSet<>(Arrays.asList(',', ':'));

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        StringParser stringParser = new StringParser(input, defaultDelimiters);

        String processedInput = stringParser.getProcessedInput();
        Set<Character> delimiters = stringParser.getDelimiters();

        System.out.println(processedInput);
        System.out.println(delimiters);
    }
}
