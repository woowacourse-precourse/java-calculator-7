package calculator;

import calculator.exception.IllegalInputException;
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

    private void containCustomSeparator() {
        if (input.startsWith("//")) {
            int separatorStartIdx = input.indexOf("//") + 2;
            int separatorEndIdx = input.indexOf("\n");

            saveCustomSeparator(separatorStartIdx, separatorEndIdx);
        }
    }

    private void saveCustomSeparator(int separatorStartIdx, int separatorEndIdx) {
        if (separatorEndIdx == -1) {
            throw new IllegalInputException();
        }
        customSeparator = input.substring(separatorStartIdx, separatorEndIdx);

        if (customSeparator.isEmpty()) {
            throw new IllegalInputException();
        }
    }
}
