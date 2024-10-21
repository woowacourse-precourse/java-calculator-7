package calculator;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public static String inputValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String text = readLine();
        close();
        return text;
    }

    public static void outputValue(int result) {
        System.out.println("결과 : " +result);
    }
}
