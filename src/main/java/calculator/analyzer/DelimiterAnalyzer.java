package calculator.analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterAnalyzer {

    // 기본 구분자와 커스텀 구분자 모두 포함하는 리스트 반환
    public List<String> getDelimiterList(String input) {
        List<String> delimiterList = getDefaultDelimiterList();

        // 커스텀 구분자를 가진 입력인 경우
        if(isContainCustomDelimiter(input)) {
            delimiterList.add(Character.toString(input.charAt(2)));
            return delimiterList;
        }
        // 커스텀 구분자가 없는 입력인 경우 기본 구분자만 포함하는 구분자 리스트 반환
        return delimiterList;
    }

    // 기본 구분자 리스트 반환
    public List<String> getDefaultDelimiterList() {
        return new ArrayList<>(Arrays.asList(",", ":"));
    }

    // 사용자 입력에 커스텀 구분자가 있는지 유무 반환
    public boolean isContainCustomDelimiter(String input) {
        if(input.length() >= 5 && input.substring(0, 2).equals("//") && input.substring(3, 5).equals("\\n"))
            return true;

        return false;
    }
}