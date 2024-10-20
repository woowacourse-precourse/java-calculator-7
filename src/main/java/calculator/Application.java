package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력하신 값이 없습니다.");
        }

        List<String> separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");

        extractCustomSep(input, separator);

    }

    // 커스텀 구분자(Separator, Sep)를 추출
    private static void extractCustomSep(String input, List<String> separator) {
        if (input.startsWith("//")) {
            int sepEndIndex = input.indexOf("\\n");
            String customSep = input.substring(2, sepEndIndex - 1);
            separator.add(customSep);
        }
    }

}