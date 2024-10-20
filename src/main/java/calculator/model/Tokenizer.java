package calculator.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final Pattern CUSTOM_OPERATION_PATTERN = Pattern.compile("^//(.*)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public static ArrayList<Integer> tokenize(String str){
        if (str == null || str.isEmpty()) {
            return new ArrayList<>(); // 빈 문자열은 합이 0이므로 빈 리스트 반환
        }

        String delimiter;
        String expression;

        if (str.startsWith("//")) {
            Matcher matcher = CUSTOM_OPERATION_PATTERN.matcher(str);
            if(matcher.find()){
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자를 사용
                expression = matcher.group(2); // 표현식은 두 번째 그룹
            }
            else{
                throw new IllegalArgumentException();
            }
        } else {
            delimiter = DEFAULT_DELIMITER;
            expression = str;
        }

        String[] tokens = expression.split(delimiter);
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException();
            }
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수 값은 허용되지 않습니다: " + token);
            }
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
