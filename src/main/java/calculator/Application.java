package calculator;

import java.io.IOError;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IOError {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        Calculator cal = new Calculator(str);

        System.out.println("결과 : " + cal.getResult());
    }
}