package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static String separator = ",:";

    public static int stringToNum(String num) {
        if (num.equals("")) {
            return 0;
        }
        return Integer.parseInt(num);
    }

    public static int calculateValue(String user_input) {
        String num = "";
        int sum = 0;
        for (int i = 0; i < user_input.length(); i++) {
            char ch = user_input.charAt(i);
            if (separator.contains(Character.toString(ch))) {
                sum += stringToNum(num);
                num = "";
            } else if ('0' <= ch && '9' >= ch) {
                num += ch;
            } else {
                throw new IllegalArgumentException();
            }
        }
        sum += stringToNum(num);

        return sum;
    }

    public static String findSeparator(String user_input) {
        if (user_input.substring(0, 2).equals("//") == false)
            return user_input;

        int limit = user_input.indexOf("\\n");
        if (limit == -1) {
            return user_input;
        } else if (limit == 2) {
            throw new IllegalArgumentException();
        }

        for (int i = 2; i < limit; i++) {
            separator += user_input.charAt(i);
        }

        return user_input.substring(limit + 2);
    }

    public static String inputByUser() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        return readLine();
    }

    public static void printOutput(int answer) {
        System.out.println(String.format("결과 : %d", answer));
    }

    public static void main(String[] args) {
        String user_input = inputByUser();
        user_input = findSeparator(user_input);
        printOutput(calculateValue(user_input));
    }
}
