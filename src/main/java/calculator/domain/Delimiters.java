package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    private final List<Character> delimiters =new ArrayList<>();

    public Delimiters() {
        this.delimiters.addAll(List.of(',',':'));
    }

    public void setCustomDelimiter(char customDelimiter) {
        this.delimiters.clear();
        this.delimiters.add(customDelimiter);
    }

    /**
     * @return 구분자를 정규식으로 변환
     */
    public String toRegexPattern() {
        return delimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .collect(Collectors.joining("|"));
    }

    public List<Character> getDelimiters() {
        return delimiters;
    }
}
