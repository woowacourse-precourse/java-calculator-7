package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static String inputByUser() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        return readLine();
    }

    public static void main(String[] args) {
        String user_input = inputByUser();
    }
}
