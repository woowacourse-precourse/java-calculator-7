package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Calculator {

    // 2. 빈 문자열 처리 기능
    public int handleEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 처리
        }
        return -1; // 처리할 값이 있는 경우
    }

}