package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {


    public static int solution(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        String seperator = ",|:";

        int sum = 0;

        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(s);
        if (m.find()) {
            String sep = m.group(1);
            String[] num= m.group(2).split(sep);

            for (String token : num) {
                sum += Integer.parseInt(token.trim());
            }
            return sum;
        }

        String[] str = s.split(seperator);

        for (String token: str) {
            if (Integer.parseInt(token.trim()) < 0) {
                throw new IllegalArgumentException();
            }

            sum += Integer.parseInt(token.trim());
        }


        return sum;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();



        try {
            System.out.println("결과 : " + solution(s));
        } catch (IllegalArgumentException e) {

        } finally {
            Console.close();
        }


    }

}


