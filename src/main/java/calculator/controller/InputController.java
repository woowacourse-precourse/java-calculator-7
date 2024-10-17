package calculator.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    private static List<String> delimiterList = new ArrayList<>(List.of(",", ":"));
    private static final String startCustom = "//";
    private static final String endCustom = "\\n";

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public static void addCustomDelimiter(String input) {
        Integer startIdx = input.indexOf(startCustom) + 2;
        Integer endIdx = input.indexOf(endCustom);
        if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
            if (delimiterList.contains(input.substring(startIdx, endIdx))) {
                throw new IllegalArgumentException("이미 추가한 구분자는 custom 으로 지정할 수 없습니다.");
            }
            delimiterList.add(input.substring(startIdx, endIdx));
        } else {
            if (startIdx == -1 || endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 추가 하기 위해선 //구분자\\n 형식 으로 입력 하세요.");
            }
            if (startIdx >= endIdx) {
                throw new IllegalArgumentException("커스텀 구분자를 입력 하세요.");
            }
        }
    }

    public static List<String> getDelimiterList() {
        return delimiterList;
    }
}
