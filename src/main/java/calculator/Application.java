package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int calculateValue(String user_input) {
        String num = "";
        int sum = 0;
        for (int i = 0; i < user_input.length(); i++) {
            char ch = user_input.charAt(i);
            if (ch == ',' || ch == ':') {
                if (num != "")
                    sum += Integer.parseInt(num);
                num = "";
            } else {
                num = num + ch;
            }
        }
        if (num != "")
            sum += Integer.parseInt(num);
        return sum;
    }

    public static String inputByUser() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        return readLine();
    }

    public static void main(String[] args) {
        String user_input = inputByUser();
        calculateValue(user_input);
    }
}
