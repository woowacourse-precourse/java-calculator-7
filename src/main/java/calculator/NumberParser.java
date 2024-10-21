package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final List<Integer> numberList;
    private final Delimiter delimiter;

    /**
     * NumberParser의 구성자 입니다.
     * @param delimiter 구분자를 가지고 있는 객체
     */
    public NumberParser(Delimiter delimiter) {
        numberList = new ArrayList<>();
        this.delimiter = delimiter;
    }

    /**
     * index 번째 숫자를 리턴합니다.
     * @param index 반환할 인덱스
     * @return index 번째 숫자.
     */
    public Integer getNumberAt(int index) {
        return numberList.get(index);
    }

    /**
     *
     * @return 분리한 숫자의 개수
     */
    public Integer getSize() {
        return numberList.size();
    }

    /**
     * 구분자로 구분될 숫자들을 목록에 추가합니다.
     * @param input 입력받은 문자열
     */
    public void parseNumber(String input) {
        int value = 0;
        for(int i = 0; i < input.length(); i ++) {
            if((i+delimiter.getCustomDelimiterLength() < input.length() &&
                    delimiter.isCustomDelimiter(input.substring(i, i+delimiter.getCustomDelimiterLength()))) ||
                    !isNumber(input.charAt(i))) {
                numberList.add(value);
                value = 0;
            }
            else {
                value = value * 10 + (input.charAt(i) - '0');
            }
        }
        if(value != 0) {
            numberList.add(value);
        }
    }
    private boolean isNumber(char c) {
        return c <= '9' && c >= '0';
    }
}
