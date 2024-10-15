package calculator;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ArrayList<String> parser = new ArrayList<String>(List.of(",", ":"));

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
    }
}
