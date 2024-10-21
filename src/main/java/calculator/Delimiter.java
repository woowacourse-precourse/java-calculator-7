package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    List<Character> delimiterList;
    private boolean hasCustomDelimiter;
    private String customDelimiter;

    /**
     * 구분자(쉼표, 콜론)와 커스텀 구분자를 구분자 목록에 추가합니다.
     * @param input 입력 받은 문자열
     */
    public Delimiter(String input) {
        delimiterList = new ArrayList<>();
        delimiterList.add(',');
        delimiterList.add(':');
        customDelimiter = "";
        if(input.startsWith("//")) {
            customDelimiter = getCustomDelimiter(input);
            hasCustomDelimiter = true;
        }
    }

    /**
     * 입력 받은 문자열이 구분자인지 여부를 반환합니다.
     * @param character 입력 받은 문자열
     * @return 구분자인지 여부
     */
    public boolean isDelimiter(Character character) {
        for (Character e : delimiterList) {
            if (e == character) {
                return true;
            }
        }
        return false;
    }

    /**
     * 주어진 문자열이 커스텀 구분자인지 확인
     * @param in 주어진 문자열
     * @return 커스텀 구분자인지 여부
     */
    public boolean isCustomDelimiter(String in) {
        return hasCustomDelimiter && in.equals(customDelimiter);
    }

    /**
     *
     * @return 커스텀 구분자의 길이
     */
    public int getCustomDelimiterLength() {
        return customDelimiter.length();
    }
    /**
     * 입력 받은 문자열에서 커스텀 구분자를 가져옵니다.
     * @param input 입력 받은 문자열
     * @return 커스텀 구분자
     */
    private String getCustomDelimiter(String input) {
        StringBuilder customDelimiter = new StringBuilder();
        int j = 2;
        while(j+2 < input.length() && !input.substring(j, j+2).startsWith("\\n")) {
            customDelimiter.append(input.charAt(j));
            j ++;
        }
        return customDelimiter.toString();
    }
}
