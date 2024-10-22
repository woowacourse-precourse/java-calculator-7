package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private List<Character> separators;

    public InputParser() {
        this.separators = new ArrayList<>(List.of(new Character[]{',', ':'}));
    }

    public List<Character> getSeparators() {
        return separators;
    }

    public String findCustomSeparator(String input) {
        int customSeparatorStart = input.indexOf("//");
        int customSeparatorEnd = input.indexOf("\\n");

        //커스텀 구분자가 존재하는 경우
        if (customSeparatorStart == 0 && customSeparatorEnd > 0) {
            for (int i = customSeparatorStart + 2; i < customSeparatorEnd; i++) {
                separators.add(input.charAt(i));
            }
        }
        //커스텀 구분자가 존재하지 않는 경우
        else if (customSeparatorStart == -1 && customSeparatorEnd == -1) {
            return input;
        }
        //커스텀 구분자 입력이 올바르지 않은 경우
        else {
            throw new IllegalArgumentException("커스텀 구분자 입력이 잘못되었습니다.");
        }

        //커스텀 구분자를 제거한 출력값 계산을 위한 문자열 반환
        return input.substring(customSeparatorEnd + 2);
    }
}
