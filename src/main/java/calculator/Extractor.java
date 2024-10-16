package calculator;

import java.util.Set;

public class Extractor {

    final String ERROR_MESSAGE = "잘못된 구분자입니다.";

    private final String input;
    private String[] strArr;
    private String customSeparator;
    private Set<Integer> numbers; // 계산할 숫자만이 저장된 Set

    public Extractor(String input) {
        this.input = input.trim();
    }


    /**
     * 문자열에서 숫자 추출
     */
    public void extractNumber() {
        containCustomSeparator();

        // TODO: 커스텀, 기본 구분자 동시에 존재할 때의 예외 처리
//        customSeparatorRemovedString = input.substring(5);

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
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        customSeparator = input.substring(separatorStartIdx, separatorEndIdx);

        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void containBasicSeparator() {
        strArr = input.split(",|:");

        // 문자열 배열의 각 문자가 양수로만 이루어져 있는지 판별
        for (String s : strArr) {
            for (int i = 0; i < s.length(); i++) {
                char targetChar = s.charAt(i);
                if (!Character.isDigit(targetChar) && Character.getNumericValue(targetChar) <= 0) {
                    throw new IllegalArgumentException(ERROR_MESSAGE);
                }
            }
        }

    }
}
