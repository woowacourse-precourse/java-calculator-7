package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));

        int result = 0;
        String[] operands;

        // read input and split
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().strip();
        operands = inputSplitter(input);

        // parse to int and print sum
        for (String operand : operands) {
            if (!operand.isEmpty()) {
                if (Character.isDigit(operand.charAt(0))) {
                    result += Integer.parseInt(operand);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        System.out.println("결과 : " + result);
    }

    public static String[] inputSplitter(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder splitPattern = new StringBuilder("[,:");
        String baseInput = input;

        // when custom separator exist
        if ((input.length() >=4) && (input.charAt(0) == '/') && (input.charAt(1) == '/')){
            int currIndex = 2;

            // check whether '\' and follow 'n' exist or not.
            // to use split function, "\\" prefix must be appended to regex operators
            Outer: while (currIndex < input.length()-1) {
                char c = input.charAt(currIndex);
                switch (c){
                    case '\\':
                        if (input.charAt(currIndex+1) == 'n') {
                            currIndex++;
                            break Outer;
                        }
                    case '[', ']', '(', ')', '{', '}', '.', '*', '+', '|', '?', '^', '$':
                        splitPattern.append('\\').append(c);
                        break;
                    default:
                        splitPattern.append(c);
                        break;
                }
                currIndex++;
            }
            baseInput = input.substring(currIndex+1);
        }

        splitPattern.append(']');
        return baseInput.split(splitPattern.toString());
    }
}
