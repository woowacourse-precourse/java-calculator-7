package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private final Set<Character> delimiterSet;

    // 기본 구분자는 생성자 호출 시에 추가
    public Delimiter() {
        this.delimiterSet = new HashSet<>();
        this.delimiterSet.add(',');
        this.delimiterSet.add(':');
    }

    // 구분자를 추가하는 메서드
    public void addDelimiter(char delimiter) {
        delimiterSet.add(delimiter);
    }

    // 구분자 집합을 사용해서 split 메서드 사용을 위한 regex를 생성하는 메서드
    private String setRegex() {
        StringBuilder sb = new StringBuilder("[");
        for (Character c : delimiterSet) {
            sb.append(c);
        }
        sb.append("]");
        return sb.toString();
    }


    // 입력받은 문자열을 split 메서드를 사용해서 구분자를 기준으로 나누는 메서드
    public String[] splitToNumbersArray(String input) {
        return input.split(setRegex());
    }
}
