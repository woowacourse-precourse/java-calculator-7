package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiters = ",|:";
        String inputTokens[] = splitByDelimiters(input, delimiters);


    }


    public static String[] splitByDelimiters(String input, String delimiters) {
        String[] inputTokens;

        if (input.startsWith("//")) {
            int start_index = input.indexOf('/');
            if (start_index + 3 == input.indexOf('\\') && start_index + 4 == input.indexOf('n')) {
                delimiters += "|" + input.charAt(start_index + 2);
                input = input.substring(start_index + 5);
            }
        }

        inputTokens = input.split(delimiters);
        return inputTokens;
    }


}
