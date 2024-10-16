package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력받음
        String input = Console.readLine();

        // 구분자를 저장하기 위한 ArrayList
        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        // 커스텀 구분자가 지정되어 있는지 확인 후, 지정되어 있다면 커스텀 구분자를 ArrayList에 추가
        if (hasCustomDelimiter(input)) {
            delimiters.add(getCustomDelimiter(input));
        }
    }

    static boolean hasCustomDelimiter(String input) { // 커스텀 구분자가 지정되어 있는지 확인하는 함수
        return input.startsWith("//");
    }

    static String getCustomDelimiter(String input) { // 문자열에서 커스텀 구분자를 추출하고 반환하는 함수
        int end_index = input.indexOf("\\n");
        return input.substring(2, end_index);
    }
}
