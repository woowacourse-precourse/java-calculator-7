package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class SeparatorManager {
    static ArrayList<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
    private String numberString;

    // 커스텀 구분자 추가하기
    public void processInput(String input) {
        if (!input.startsWith("//") || !input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        ArrayList<String> parts = new ArrayList<>(Arrays.asList(input.split("\\\\n")));

        String customSeparators = parts.get(0).substring(2).trim();

        for (String separator : customSeparators.split("[,\\:]")) {
            if (separator.trim().matches("\\d+")) { // 숫자 형식 체크
                throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다: ");
            }
        }

        // 구분자를 올바르게 분리하여 숫자 문자열 설정
        numberString = parts.get(1); // 숫자 부분은 항상 두 번째 부분입니다.

        // 구분자를 ',' 또는 ':'로 추가
        ArrayList<String> customSeparatorList = new ArrayList<>(Arrays.asList(customSeparators.split("[,\\:]")));
        separators.addAll(customSeparatorList);
    }

    // 숫자 부분 넘겨주기
    public String getNumberString() {
        return numberString;
    }

    public ArrayList<String> getSeparators() {
        return separators;
    }

}