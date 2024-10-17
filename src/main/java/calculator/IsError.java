package calculator;

import java.util.*;

public class IsError {
    public IsError() { }

    public void checkError(List<Character> problemMatcher) {
        if(problemMatcher.isEmpty())
            return;
        else
            throw new IllegalArgumentException("잘못된 문자열이 입력되었습니다.");
    }
}
