package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiters = ",|:";
        delimiters = updateDelimiters(input, delimiters);


    }


    public static String updateDelimiters(String input, String delimiters) {

        String updateDelimiters = delimiters;

        if (input.startsWith("//")) {
            int start_index = input.indexOf('/');
            if (start_index + 3 == input.indexOf('\\') && start_index + 4 == input.indexOf('n')) {
                delimiters += "|" + input.charAt(start_index + 2);
                input = input.substring(start_index + 5);
            }
        }
        return updateDelimiters;
    }

}
