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

        if (input.startsWith("//")) {
            extractCustomSep(input, separator);
        }

        String[] separatedNumber = splitNumberBySeparator(input, separator);

    }

    // 커스텀 구분자(Separator, Sep)를 추출
    private static void extractCustomSep(String input, List<String> separator) {
        if (input.startsWith("//")) {
            int sepEndIndex = input.indexOf("\\n");
            String customSep = input.substring(2, sepEndIndex - 1);
            separator.add(customSep);
        }
    }

    private static String[] splitNumberBySeparator(String input, List<String> separator) {
        // custom구분자가 있는 경우
        if (input.startsWith("//")) {
            int sepEndIndex = input.indexOf("\\n");
            System.out.println("sepEndIndex = " + sepEndIndex);

            // 커스텀 구분자가 있으면 구분자 이후의 문자열만 input에 넣음
            input = input.substring(sepEndIndex + 2);
            System.out.println("input = " + input);
        }

        String[] separatedNumber = input.split(separator.get(0));

        for (int i = 1; i < separator.size(); i++) {
            List<String> tempStorage = new ArrayList<>();
            for (String numStr : separatedNumber) {
                System.out.println("numStr = " + numStr);
                String[] tempSplit = numStr.split(separator.get(i));
                for (String s : tempSplit) {
                    System.out.println("s = " + s);
                    tempStorage.add(s.trim());
                }
            }
            separatedNumber = tempStorage.toArray(new String[0]);
        }
        return separatedNumber;
    }


}