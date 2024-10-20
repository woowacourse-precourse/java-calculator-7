package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(","); // 기본 구분자
        delimiters.add(":"); // 기본 구분자

        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n"); // '\n'의 위치 확인
            String customDelimiter = input.substring(2, newlineIndex).trim(); // 커스텀 구분자 추출
            delimiters.add(customDelimiter); // 커스텀 구분자 리스트에 추가
            input = input.substring(newlineIndex + 2); // 커스텀 구분자 부분 제거
        }

        StringBuilder regexBuilder = new StringBuilder();
        for (String delimiter : delimiters) {
            regexBuilder.append(Pattern.quote(delimiter)).append("|"); // 각 구분자를 이스케이프
        }
        String delimiterRegex = regexBuilder.substring(0, regexBuilder.length() - 1);

        String[] splitNums = input.split(delimiterRegex);

        int sum = 0;
        for (String num : splitNums) {
            int number = Integer.parseInt(num);
            sum += number;
        }
        System.out.printf("결과 : %d%n", sum);
    }
}
