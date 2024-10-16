package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static String separator = ",:";

    public static int calculateValue(String user_input) {
        String num = "";
        int sum = 0;
        for (int i = 0; i < user_input.length(); i++) {
            String ch = "";
            ch += user_input.charAt(i);
            if (separator.contains(ch)) {
                if (num != "")
                    sum += Integer.parseInt(num);
                num = "";
            } else {
                num += ch;
            }
        }
        if (num != "")
            sum += Integer.parseInt(num);
        return sum;
    }

    public static String findSeparator(String user_input) {
        if (user_input.substring(0, 2).equals("//") == false)
            return user_input;
        if (user_input.indexOf("\\n") == -1)
            return user_input;

        int i;
        for (i = 2; i < user_input.length(); i++) {
            if (user_input.substring(i, i + 2).equals("\\n"))
                break;
            separator += user_input.charAt(i);
        }

        return user_input.substring(i + 2);
    }

    public static String inputByUser() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        return readLine();
    }

    public static void main(String[] args) {
        String user_input = inputByUser();
        user_input = findSeparator(user_input);
        System.out.println(calculateValue(user_input));
    }
}
