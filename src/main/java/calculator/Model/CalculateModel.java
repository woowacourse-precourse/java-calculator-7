package calculator.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateModel {

    public int calculate(String input) {
        String[] numbers;

        //빈 문자열이면 0 반환
        if (input.isEmpty()) {
            return 0;
        }

        //custom 구분자 있는지 확인
        String regex = "//(.*?)\\\\n(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter);
            System.out.println("customDelimiter : " + customDelimiter);
            System.out.println("numbers : " + numbers);

        } else {
            //없으면 , : 기준으로 split
            numbers = input.split(",|:");
        }
        return sum(numbers);
    }

    //SUM
    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += intParser(number);
        }
        return sum;
    }

    //문자열을 정수로 변환 + 예외처리
    private int intParser(String number) {
        System.out.println(number);
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다." + intNumber);
            }
            return intNumber;
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("잘못된 숫자 형식입니다." + number);
        }
    }
}
