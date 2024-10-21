package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    List<String> delimiterList;

    /**
     * 구분자(쉼표, 콜론)와 커스텀 구분자를 구분자 목록에 추가합니다.
     * @param input 입력 받은 문자열
     */
    public Delimiter(String input) {
        delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(":");
        if(input.startsWith("//")) {
            String customDelimiter = getCustomDelimiter(input);
            delimiterList.add(customDelimiter);
        }
    }

    /**
     * 입력 받은 문자열에서 커스텀 구분자를 가져옵니다.
     * @param input 입력 받은 문자열
     * @return 커스텀 구분자
     */
    private String getCustomDelimiter(String input) {
        StringBuilder customDelimiter = new StringBuilder();
        int j = 2;
        while(j+2 < input.length() && input.substring(j, j+2).startsWith("\n")) {
            j ++;
            customDelimiter.append(input.charAt(j));
        }
        return customDelimiter.toString();
    }
}
