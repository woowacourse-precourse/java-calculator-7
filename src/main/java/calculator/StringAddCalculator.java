package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public double splitAndSum(String exp) {
        String[] numbers;
        String delimiter = "";
        double result = 0;

        // 빈 문자열 확인
        if(exp==null || exp.trim().isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }

        // 커스텀 문자열 확인
        if(exp.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.+)\n").matcher(exp);
            if(matcher.find()) {
                delimiter = matcher.group(1);
                exp = exp.substring(exp.indexOf("\n") + 1);
            } else {
                throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
            }
        } else {
            delimiter = ",|:";
        }

        numbers = exp.split(delimiter);

        for(String number : numbers) {
            double strToNum;
            try {
                strToNum = Double.parseDouble(number);
                result += strToNum;
                if(strToNum <= 0)
                    throw new IllegalArgumentException("양수만 입력 가능합니다: " + strToNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 입력값입니다: " + number);
            }
        }
        return result;
    }
}
