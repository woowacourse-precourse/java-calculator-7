package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        DelimiterManager delimiterManager = new DelimiterManager(',', ':');
        Separator separator = new Separator(input, delimiterManager);

        separator.extractCustomDelimiter("//", "\\n");
        List<String> separateList = separator.separate();
        int result = Separator.getSum(separateList);

        System.out.println("결과 : " + result);
    }
}
