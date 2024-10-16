package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCalculator {
    
    public int calculate(String expression) {
        if(expression == null || expression.trim().isEmpty()) {
            return 0;
        }
        
        // 넘어오는 \n값을 우리가 Pattern에서 설정한 \\과 맞추어 주기 위한 코드
        // \n은 Java 문자열에서 이스케이프 처리되어야 하므로 \\n으로 표현
        expression = expression.replace("\\n", "\n");
        
        // 왼쪽부터 () 가 하나의 그룹으로 묶임
        // (.)는 어떤 하나의 단일 문자이든지 매칭 -> 나중에 하나의 단일문자가 아니라 n개 이상의 문자도 들어올경우 .* 로 변경
        // (.*)은 0개 이상의 모든 문자와 매칭
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(expression);
        
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            
            // Pattern.quote(delimiter)를 사용하여 구분자를 리터럴 문자열로 처리
            // 이는 구분자에 정규표현식 특수 문자가 포함되어도 의도대로 동작하게 함
            return sum(numbers.split(Pattern.quote(delimiter)));
        } else {
            // 정규표현식에 의해서 [] 안에 나열된 문자들 중 하나와 매치됨을 의미
            return sum(expression.split("[,:]"));
        }
    }
    
    private int sum(String[] numbers) {
        int parseToInt;
        int result = 0;
        for (String number : numbers) {
            parseToInt = Integer.parseInt(number.trim());
            result += parseToInt;
        }
        return result;
    }
}
