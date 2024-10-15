package calculator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private Integer result = 0;
    private static List<String> delimiterList = List.of(",", ":");
    private static final String startCustom = "//";
    private static final String endCustom = "\\n";

    public static void main(String[] args) {
        String input = readLine();
        if (input.startsWith(startCustom)) {
            addCustomDelimiter(input);
        }
    }

    private static void addCustomDelimiter(String input) {
        Integer startIdx = input.indexOf(startCustom) + 2;
        Integer endIdx = input.indexOf(endCustom);
        if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
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
}
