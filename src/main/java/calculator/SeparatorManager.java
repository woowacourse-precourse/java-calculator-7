package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class SeparatorManager {
    static ArrayList<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    // 커스텀 구분자 추가하기
    public void processInput(String input) {
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(input.split("\n")));

        String customSeparators = parts.get(0).substring(2).trim();
        if (customSeparators.contains("\\")) {
            customSeparators = customSeparators.split("\\\\")[0];
        }

        ArrayList<String> customSeparatorList = new ArrayList<>(Arrays.asList(customSeparators.split("[,\\:]")));
        separators.addAll(customSeparatorList);
    }

}
