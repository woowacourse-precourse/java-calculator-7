package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (hasCustomDelimiter(input)) {
            delimiters.add(getCustomDelimiter(input));
        }
    }

    static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    static String getCustomDelimiter(String input) { // 문자열에서 커스텀 구분자를 추출하고 반환하는 함수
        int end_index = input.indexOf("\\n");
        return input.substring(2, end_index);
    }
}
