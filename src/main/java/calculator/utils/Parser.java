package calculator.utils;


import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    // 커스텀 구분자가 있는지 확인하는 메소드
    private boolean checkCustomSeparator(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        if (firstIndex == -1 && secondIndex == -1) {
            return false;
        } else if (firstIndex == 0 && secondIndex >= 0) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    // 구분자를 반환하는 메소드
    private List<Character> getSeparators(String input) {
        List<Character> separators = new ArrayList<>();
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        for (int i = 2; i < secondIndex; i++) {
            separators.add(input.charAt(i));
        }
        return separators;
    }


}
