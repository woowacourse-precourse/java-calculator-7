package calculator.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateModel {

    public int calculate(String input) {
        String[] Numbers;

        //빈 문자열이면 0 반환
        if (input.isEmpty()) {
            return 0;
        }

        //custom 구분자 있는지 확인
        String regex = "//(.)\n(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            Numbers = matcher.group(2).split(customDelimiter);

        } else {
            //없으면 , : 기준으로 split
            Numbers = input.split(",|:");
        }
        return sum(Numbers);
    }

    //sum

    //잘못된 값이면 illegalArgumentException 던지고 종료
}
