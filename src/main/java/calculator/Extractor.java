package calculator;

import java.util.Set;

public class Extractor {

    private final String input;
    private Set<Integer> numbers;
    private String[] strArr;
    private String customSeparator;

    public Extractor(String input) {
        this.input = input.trim();
    }


    /**
     * 문자열에서 숫자 추출
     */
    public void extractNumber() {
        containCustomSeparator();
        containBasicSeparator();

        for (String str : strArr) {
            numbers.add(Integer.valueOf(str));
        }
    }
}
