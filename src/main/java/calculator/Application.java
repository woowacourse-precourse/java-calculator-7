package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine(); // 문자열 입력
        List<String> delimiters = getDelimiters(input); // 커스텀 구분자 확인
    }

    private static List<String> getDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        int len = input.length();
        int start = -1;
        int end = -1;
        for (int i = 0; i < len - 1; i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                start = i + 2;
            }
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                end = i - 1;
            }
        }

        if (start != -1 && end != -1) {
            String delimiter = "";
            for (int i = start; i <= end; i++) {
                delimiter += input.charAt(i);
            }
            delimiters.add(delimiter);
        }

        return delimiters;
    }
}