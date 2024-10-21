package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final Pattern PATTERN = Pattern.compile("\\d+"); // 숫자 패턴을 상수로 정의
    private static final List<Integer> numberList = new ArrayList<>();

    private static void extractNumbers(String expression) {
        Matcher matcher = PATTERN.matcher(expression);

        // 정규식 패턴에 매칭되는 모든 숫자를 리스트에 추가
        while (matcher.find()) {
            numberList.add(Integer.parseInt(matcher.group()));
        }
    }
    public static List<Integer> getNumberList(String expression){
        extractNumbers(expression);
        return numberList;
    }
}
