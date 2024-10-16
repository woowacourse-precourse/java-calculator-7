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

    //SUM
    private int sum(String[] Numbers) {
        int sum = 0;
        for (String number : Numbers) {
            sum += intParser(number);
        }
        return sum;
    }

    //문자열을 정수로 변환 + 예외처리
    private int intParser(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }
}
